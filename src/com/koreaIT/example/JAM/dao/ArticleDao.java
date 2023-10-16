package com.koreaIT.example.JAM.dao;

import java.sql.Connection;

import com.koreaIT.example.JAM.util.DBUtil;
import com.koreaIT.example.JAM.util.SecSql;

public class ArticleDao {
	private Connection conn;

	public ArticleDao(Connection conn) {
		this.conn = conn;
	}

	public void doWrite(int id, String regDate, String updateDate, String title, String body) {
		SecSql sql = new SecSql();
		sql.append("INSERT INTO article");
		sql.append("SET regDate = NOW(),");
		sql.append("updateDate = NOW(),");
		sql.append("title = ?,", title);
		sql.append("`body` = ?", body);
		DBUtil.insert(conn, sql);
	}

	public void doModify(int id, String regDate, String updateDate, String newTitle, String newBody) {
		SecSql sql = new SecSql();
		sql.append("UPDATE article");
		sql.append("SET updateDate = NOW(),");
		sql.append("title = ?,", newTitle);
		sql.append("`body` = ?", newBody);
		sql.append("WHERE id = ?", id);

		DBUtil.update(conn, sql);
	}
}
