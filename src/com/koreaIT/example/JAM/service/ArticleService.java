package com.koreaIT.example.JAM.service;

import java.sql.Connection;

import com.koreaIT.example.JAM.dao.ArticleDao;

public class ArticleService {
	private ArticleDao articleDao;

	public ArticleService(Connection conn) {
		this.articleDao = new ArticleDao(conn);
	}

	public void doWrite(int id, String regDate, String updateDate, String title, String body) {
		articleDao.doWrite(id, regDate, updateDate, title, body);
	}
}
