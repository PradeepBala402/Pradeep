
<%-- <%@ page import="java.sql.*"%>
<%
	String s = request.getParameter("val");
	if (s == null || s.trim().equals("")) {
		out.print("please enter id::");
	} else {
		int id = Integer.parseInt(s);
		out.println(id);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pradeep", "root",
					"password");
			PreparedStatement ps = con.prepareStatement("select * from emp where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				out.print(rs.getInt(1) + "" + rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
%> --%>

 <%@ page import="java.sql.*"%>  
  
<%  
String s=request.getParameter("val");  
if(s==null || s.trim().equals("")){  
out.print("Please enter id");  
}else{  
int id=Integer.parseInt(s);  
out.print(id);  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pradeep","root","password");  
PreparedStatement ps=con.prepareStatement("select * from emp where id=?");  
ps.setInt(1,id);  
ResultSet rs=ps.executeQuery();  
while(rs.next()){  
out.print(rs.getInt(1)+" "+rs.getString(2));  
}  
con.close();  
}catch(Exception e){e.printStackTrace();}  
}  
%>    