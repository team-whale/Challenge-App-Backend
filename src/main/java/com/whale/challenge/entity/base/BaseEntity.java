package com.whale.challenge.entity.base;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@ToString
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BaseEntity extends BaseTimeEntity {

	@CreatedBy
	@Column(updatable = false, length = 20)
	@Comment("등록자")
	private String insUserId;

	@LastModifiedBy
	@Column(length = 20)
	@Comment("수정자")
	private String updUserId;

}

