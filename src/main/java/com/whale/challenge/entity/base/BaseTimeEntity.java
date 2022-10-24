package com.whale.challenge.entity.base;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.whale.challenge.module.json.deserializer.CustomLocalDateTimeDeserializer;
import com.whale.challenge.module.json.serializer.CustomLocalDateTimeSerializer;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@ToString
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BaseTimeEntity {

	@CreatedDate
	@JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@Column(columnDefinition = "DATETIME", name = "INS_DTM", updatable = false)
	@Comment("등록 일시")
	private LocalDateTime insDtm;

	@LastModifiedDate
	@JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@Column(columnDefinition = "DATETIME", name = "UPD_DTM")
	@Comment("수정 일시")
	private LocalDateTime updDtm;

}