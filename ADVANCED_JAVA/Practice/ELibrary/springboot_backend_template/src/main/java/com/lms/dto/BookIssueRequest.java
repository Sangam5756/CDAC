package com.lms.dto;

import lombok.Data;

@Data
public class BookIssueRequest {
	private Long memberId;
	private Long bookId;
}
