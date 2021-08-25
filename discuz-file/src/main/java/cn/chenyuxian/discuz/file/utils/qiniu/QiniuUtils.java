package cn.chenyuxian.discuz.file.utils.qiniu;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

@Component
public class QiniuUtils {

	@Value("${qiniu.access-key}")
	private String accessKey;

	@Value("${qiniu.secret-key}")
	private String secretKey;

	@Value("${qiniu.bucket}")
	private String bucket;

	@Value("${qiniu.domain}")
	private String domain;

	private UploadManager uploadManager;

	private BucketManager bucketManager;

	private Auth auth;

	private StringMap putPolicy;

	@PostConstruct
	public void init() {
		auth = Auth.create(accessKey, secretKey);
		Configuration configuration = new Configuration(Region.huadong());
		uploadManager = new UploadManager(configuration);
		bucketManager = new BucketManager(auth, configuration);
		putPolicy = new StringMap();
		putPolicy.put("returnBody",
				"{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
	}

	public String upload(InputStream inputStream, String key)
			throws QiniuException, UnsupportedEncodingException {
		String uploadToken = auth.uploadToken(bucket, null, 3600, putPolicy);
		Response response = uploadManager.put(inputStream, key, uploadToken, null, null);
		return response.bodyString();
	}

	public Map<String, String> download(String key, long expireInSeconds) throws UnsupportedEncodingException, QiniuException {
		String encodedFileName = URLEncoder.encode(key, "utf-8").replace("+", "%20");
		String publicUrl = String.format("%s/%s", "http://" + domain, encodedFileName);
		String downloadUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
		Map<String, String> map = new HashMap<>(1);
		map.put("url", downloadUrl);
		return map;
	}
	
	public void delete(String key) throws QiniuException {
		bucketManager.delete(bucket, key);
	}
	
	public List<String> lists(String prefix) {
		BucketManager.FileListIterator iterator = bucketManager.createFileListIterator(bucket, prefix);
		List<String> list = new ArrayList<>();
		while(iterator.hasNext()) {
			FileInfo[] items = iterator.next();
			for(FileInfo item : items) {
				list.add(item.key);
			}
		}
		return list;
	}
}
