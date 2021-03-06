package online.zhaopei.myproject.sqlprovide.ecssent;

import java.io.Serializable;

import org.apache.ibatis.jdbc.SQL;

import online.zhaopei.myproject.common.tool.OracleTool;
import online.zhaopei.myproject.domain.ecssent.Member;

public class MemberSqlProvide implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5516476884598015054L;

	public String insertMemberSql(final Member member) {
		return new SQL() {{
			this.INNER_JOIN("member");
			
			OracleTool.values(this, "member_name", member.getMemberName());
			OracleTool.values(this, "password", member.getPassword());
		}}.toString();
	}
	
	public String countMemberSql(final Member member) {
		return new SQL() {{
			this.SELECT("count(1)");
			this.FROM("member");
			
			OracleTool.where(this, "member_name", member.getMemberName());
		}}.toString();
	}
	
	public String deleteMemberSql(final Member member) {
		return new SQL() {{
			this.DELETE_FROM("member");
			
			OracleTool.where(this, "member_name", member.getMemberName());
		}}.toString();
	}
	
	public String updateMemberSql(final Member member) {
		return new SQL() {{
			this.UPDATE("member");
			OracleTool.set(this, "password", member.getPassword());
			OracleTool.where(this, "member_name", member.getMemberName());
		}}.toString();
	}
	
	public String getMemberListSql(final Member member) {
		return new SQL() {{
			this.SELECT("member_name");
			this.SELECT("password");
			
			this.FROM("memeber");
			
			OracleTool.where(this, "member_name", member.getMemberName());
		}}.toString();
	}
	
	public String getMemberByUserNameSql(final String userName) {
		return new SQL() {{
			this.SELECT("member_name");
			this.SELECT("password");
			this.FROM("member");
			
			this.WHERE("member_name = '" + userName + "'");
		}}.toString();
	}
}
