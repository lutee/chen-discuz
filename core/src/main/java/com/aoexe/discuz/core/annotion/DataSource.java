package com.aoexe.discuz.core.annotion;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface DataSource {

	SourceName value();

	public enum SourceName {
		MASTER,

		SLVAE
	}
}
