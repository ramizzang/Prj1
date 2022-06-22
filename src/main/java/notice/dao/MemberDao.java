package notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import notice.db.DBCon;
import notice.vo.Member;

public class MemberDao {
	
	public Member getMember(String uid) throws Exception {
		Connection conn=DBCon.getConnection();
		
		String sql="select * from nmember where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, uid);
		ResultSet rs=pstmt.executeQuery();
		
		Member m=null;
		
		if(rs.next()) {//아이디 있으면
			m=new Member();
			m.setId(rs.getString("id"));
			m.setPwd(rs.getString("pwd"));
			
			//멤버에 잘 담겼는지 확인
			System.out.println("m.id : " +m.getId());			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return m;
	}

}
