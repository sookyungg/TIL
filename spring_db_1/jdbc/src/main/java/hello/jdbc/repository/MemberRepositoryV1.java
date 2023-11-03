package hello.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

import javax.sql.DataSource;

import org.springframework.jdbc.support.JdbcUtils;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

/**
 * JDBC - DataSource 사용, JdbcUtils 사용
 * */

/**
 * - DataSource 의존관계 주입
 * 외부에서 DataSource 를 주입 받아서 사용한다. 이제 직접 만든 DBConnectionUtil 을 사용하지 않 아도 된다.
 * DataSource 는 표준 인터페이스 이기 때문에 DriverManagerDataSource 에서 HikariDataSource 로 변경되어도 해당 코드를 변경하지 않아도 된다.
 *
 * - JdbcUtils 편의 메서드
 * 스프링은 JDBC를 편리하게 다룰 수 있는 JdbcUtils 라는 편의 메서드를 제공한다.
 * JdbcUtils 을 사용하면 커넥션을 좀 더 편리하게 닫을 수 있다.
 * */

@Slf4j
public class MemberRepositoryV1 {

	private final DataSource dataSource;

	public MemberRepositoryV1(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Member save(Member member) throws SQLException {
		String sql = "insert into member(member_id, money) values (?, ?)";
		Connection con = null;
		// 이걸로 db에 쿼리를 날리는 것
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			//SQL에 대한 파라미터 바인딩 ?에 딱딱 들어가게
			pstmt.setString(1, member.getMemberId());
			pstmt.setInt(2, member.getMoney());
			pstmt.executeUpdate();
			return member;
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {

			close(con, pstmt, null);
		}
	}

	public Member findById(String memberId) throws SQLException {
		String sql = "select * from member where member_id = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMoney(rs.getInt("money"));
				return member;
			} else {
				throw new NoSuchElementException("member not found memberId=" + memberId);
			}

		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(con, pstmt, rs);
		}
	}

	public void update(String memberId, int money) throws SQLException {
		String sql = "update member set money=? where member_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, memberId);
			int resultSize = pstmt.executeUpdate();
			log.info("resultSize={}", resultSize);
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(con, pstmt, null);
		}
	}

	public void delete(String memberId) throws SQLException {
		String sql = "delete from member where member_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		} finally {
			close(con, pstmt, null);
		}
	}

	/**
	 * 리소스 정리는 꼭! 해주어야 한다. 따라서 예외가 발생하든, 하지 않든 항상 수행되어야 하므로 finally
	 * 구문에 주의해서 작성해야한다. 만약 이 부분을 놓치게 되면 커넥션이 끊어지지 않고 계속 유지되는 문제가 발 생할 수 있다.
	 * 이런 것을 리소스 누수라고 하는데, 결과적으로 커넥션 부족으로 장애가 발생할 수 있다.
	 * */
	private void close(Connection con, Statement stmt, ResultSet rs) {

		JdbcUtils.closeResultSet(rs);
		JdbcUtils.closeStatement(stmt);
		JdbcUtils.closeConnection(con);

	}

	private Connection getConnection() throws SQLException {
		Connection con = dataSource.getConnection();
		log.info("get connection={}, class={}", con, con.getClass());
		return con;
	}
}
