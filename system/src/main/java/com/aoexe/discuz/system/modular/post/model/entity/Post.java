package com.aoexe.discuz.system.modular.post.model.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenyuxian
 * @since 2021-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帖子 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 最后回复用户 id
     */
    private Long lastRepliedUserId;

    /**
     * 分类 id
     */
    private Integer categoryId;

    /**
     * 类型：0普通 1长文 2视频 3图片
     */
    private Integer type;

    /**
     * 标题
     */
    private String title;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 附件价格
     */
    private BigDecimal attachmentPrice;

    /**
     * 免费字数百分比
     */
    private Double freeWords;

    /**
     * 回复数
     */
    private Integer postCount;

    /**
     * 查看数
     */
    private Integer viewCount;

    /**
     * 打赏数
     */
    private Integer rewardedCount;

    /**
     * 付费数
     */
    private Integer paidCount;

    /**
     * 分享数
     */
    private Integer shareCount;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 位置
     */
    private String location;

    /**
     * 最新评论时间
     */
    private LocalDateTime repliedAt;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 删除时间
     */
    private LocalDateTime deletedAt;

    /**
     * 删除用户 id
     */
    private Long deletedUserId;

    /**
     * 是否合法
     */
    private Integer isApproved;

    /**
     * 是否置顶
     */
    private Integer isSticky;

    /**
     * 是否加精
     */
    private Integer isEssence;

    /**
     * 是否推荐到首页（0否 1是）
     */
    private Integer isSite;

    /**
     * 是否匿名 0否 1是
     */
    private Integer isAnonymous;

    /**
     * 是否显示 0否 1是
     */
    private Integer isDisplay;

    /**
     * 是否添加红包，0未添加，1添加
     */
    private Integer isRedPacket;

    /**
     * 是否为草稿，0不是，1是
     */
    private Integer isDraft;


}
