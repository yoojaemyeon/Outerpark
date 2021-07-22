package dao;

<<<<<<< HEAD
import util.JDBCUtil;
import vo.PackVO;
=======
import java.util.ArrayList;
import java.util.HashMap;

import util.JDBCUtil;
import vo.*;

>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9

public class PackDAO {
	private static PackDAO instance = new PackDAO();
	public static PackDAO getInstance() {
		return instance;
	}
	
	private PackDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertPack(PackVO vo) {
<<<<<<< HEAD
		String query = String.format("INSERT INTO PACK VALUES(SEQ_PACK.NEXTVAL,%d,%d,'%s','%d','%d',%d)"
				,vo.getTourNumber(),vo.getRoomNumber(),vo.getCarNumber(),vo.getStartDate(),vo.getEndDate(),vo.getPeople() );
		return jdbc.update(query);
=======
		String query = String.format("INSERT INTO PACK VALUES(SEQ_PACK.NEXTVAL,%d,%d,'%s','%s','%s',%d)"
				,vo.getTourNumber(),vo.getRoomNumber(),vo.getCarNumber(),vo.getStartDate(),vo.getEndDate(),vo.getPeople() );
		return jdbc.Update(query);
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
	}
	
	public int getPackNumber() {
		String query = "SELECT A.PACK_NUMBER \r\n"
				+ "      FROM ( SELECT PACK_NUMBER FROM PACK\r\n"
				+ "              ORDER BY 1 DESC) A\r\n"
				+ "     WHERE ROWNUM = 1";
<<<<<<< HEAD
		return jdbc.selectint(query, "PACK_NUMBER");
	}
}
=======
		return jdbc.Selectint(query, "PACK_NUMBER");
	}

}
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
