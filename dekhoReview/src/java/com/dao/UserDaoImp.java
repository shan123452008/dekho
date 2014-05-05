package com.dao;

import com.user.RestroSearch;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.user.AddBlog;
import com.user.AddCar;
import com.user.AddCarComment;
import com.user.AddComment;
import com.user.AddMovie;
import com.user.AddRestro;
import com.user.AddRestroComment;
import com.user.AddUserBlog;
import com.user.User;

@Repository
public class UserDaoImp implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setJdbcTemplate(DataSource dataSource) {
		System.out.println("Constructor");
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public List<User> userList() {
		String query = "select * from user.login";
		// List<?> list = jdbcTemplate.queryForList(query);

		List<User> userList = jdbcTemplate.query(query, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setUserName(rs.getString("userName"));
				user.setRoll(rs.getString("roll"));
				user.setPassWord(rs.getString("passWord"));
				return user;
			}
		});
		// return (List<User>) list;
		return userList;
	}

	@Override
	public void addUser(User user,String path) {
		System.out.println("DAO");
		 


			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			   Calendar cal = Calendar.getInstance();
			   System.out.println(dateFormat.format(cal.getTime()));
		 
		
		
		String sql = "INSERT INTO user_data.userdata(user_name,password,name,mob_number,email,pic_path,comments,date) VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { user.getUserName(),user.getPassWord(), user.getName(),user.getMobNumber(),user.getEmail(),path,user.getComment(),dateFormat.format(cal.getTime())});
		
		System.out.println("Done entries.>>>"+sql);
	}
	
	
	@Override
	public void addComment(AddComment addComment) {
		System.out.println("DAO addComment");
		 


			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			   Calendar cal = Calendar.getInstance();
			   System.out.println(dateFormat.format(cal.getTime()));
		 
		
		
		String sql = "INSERT INTO user_data.commentdata(itemId,name,email,comments,date,ratings) VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { addComment.getComment_post_ID(),addComment.getAuthor(), addComment.getEmail(),addComment.getComment(),dateFormat.format(cal.getTime()),addComment.getRatings()});
		
		System.out.println("Done entries.addComment>>>"+sql);
	}
	
	@Override
	public void addCarComment(AddCarComment addComment) {
		System.out.println("DAO addComment");
		 


			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			   Calendar cal = Calendar.getInstance();
			   System.out.println(dateFormat.format(cal.getTime()));
		 
		
		
		String sql = "INSERT INTO user_data.carcomment(itemId,name,email,comments,date,ratings) VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { addComment.getComment_post_ID(),addComment.getAuthor(), addComment.getEmail(),addComment.getComment(),dateFormat.format(cal.getTime()),addComment.getRatings()});
		
		System.out.println("Done entries.addComment>>>"+sql);
	}
	
	@Override
	public void addRestroComment(AddRestroComment addComment) {
		System.out.println("DAO addComment");
		 


			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			   Calendar cal = Calendar.getInstance();
			   System.out.println(dateFormat.format(cal.getTime()));
		 
		
		
		String sql = "INSERT INTO user_data.restrocomment(itemId,name,email,comments,date,ratings) VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { addComment.getComment_post_ID(),addComment.getAuthor(), addComment.getEmail(),addComment.getComment(),dateFormat.format(cal.getTime()),addComment.getRatings()});
		
		System.out.println("Done entries.addComment>>>"+sql);
	}

	
	public void deleteUser(String userName) {
		System.out.println("Delete Dao");
		String sql = "delete from login where userName='" + userName + "'";
		jdbcTemplate.execute(sql);
	}

	public void deleteUser() {
		System.out.println("Delete Dao");
		String sql = "delete from login where roll !='admin'";
		jdbcTemplate.execute(sql);
	}

	@Override
	public User getUserRecord(String userName) {
		System.out.println("GetRecords");
		// String sql = "select * from login where userName='" + userName + "'";
		return jdbcTemplate.query("select * from login where userName = ?",
				new Object[] { userName }, new ResultSetExtractor<User>() {
					@Override
					public User extractData(ResultSet rs) throws SQLException {
						User user = null;
						if (rs.next()) {
							user = new User();
							user.setUserName(rs.getString("userName"));
							user.setRoll(rs.getString("roll"));
							user.setPassWord(rs.getString("passWord"));

						}
						return user;
					}
				});
		// return userRecords(sql);
	}

	public User userRecords(String sql) {
		List<Map<String, Object>> userMapList = jdbcTemplate.queryForList(sql);
		User user = new User();
		System.out.println(jdbcTemplate.queryForList(sql));
		if (jdbcTemplate.queryForList(sql).size() > 0) {
			user.setUserName((String) userMapList.get(0).get("userName"));
			user.setPassWord((String) userMapList.get(0).get("passWord"));
			user.setRoll((String) userMapList.get(0).get("roll"));
		}
		System.out.println(user);
		return user;

	}

	@Override
	public User signIn(User user) {
		String sql = "select * from login where userName='"
				+ user.getUserName() + "' and passWord='" + user.getPassWord()
				+ "'";
		return userRecords(sql);
	}

	@Override
	public void editUser(User user) {
		if (user.getUserName().equalsIgnoreCase("arun")) {
			user.setRoll("admin");
		} else {
			user.setRoll("user");
		}
		System.out.println("Update");
		System.out.println(user.getPassWord());
		String sql = "update login set passWord=? , roll=?  where userName = ?";
		jdbcTemplate.update(sql, new Object[] { user.getPassWord(),
				user.getRoll(), user.getUserName() });

	}

	@Override
	public User getUserName(String value) {
		String query = "select * from login where userName like '" + value
				+ "%'";
		System.out.println("QUERY " + query);
		return userRecords(query);

	}
	
	
	public List<Map<String, Object>> getDetailsList() throws DataAccessException {
		System.out.println("inside product list..");
		
		String query = "select * from user_data.userdata";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList..."+getProductList);
		return getProductList;
		
	}
	
	
	


	@Override
	public List<Map<String, Object>> getDetailsList(String userName) {
System.out.println("inside product list..");
		
		String query = "select * from user_data.userdata where user_name='"+userName+"'";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList..."+getProductList);
		return getProductList;
	}

	@Override
	public List<Map<String, Object>> getDetailsPic(String id) throws DataAccessException {
		System.out.println("inside getDetailsPic list..");
		
		String query = "select * from user_data.userdata where id='"+id+"'";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList.>>?????.."+getProductList);
		return getProductList;
	}
	
	@Override
	public List<Map<String, Object>> getCarsDetails(String id) throws DataAccessException {
		System.out.println("inside getDetailsPic list..");
		
		String query = "select * from user_data.cars where id='"+id+"'";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList.>>?????.."+getProductList);
		return getProductList;
	}
	
	@Override
	public List<Map<String, Object>> getRestroDetails(String id) throws DataAccessException {
		System.out.println("inside getDetailsPic list..");
		
		String query = "select * from user_data.restro where id='"+id+"'";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList.>>?????.."+getProductList);
		return getProductList;
	}
	
	@Override
	public List<Map<String, Object>> getBlogPic(String id) throws DataAccessException {
		System.out.println("inside getDetailsPic list..");
		
		String query = "select * from user_data.blog where id='"+id+"'";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList.>>?????.."+getProductList);
		return getProductList;
	}
	
	@Override
	public List<Map<String, Object>> getDetailsComments(String id) throws DataAccessException {
		System.out.println("inside getDetailsPic list..");
		
		String query = "select * from user_data.commentdata where itemId='"+id+"'";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getDetailsComments listsssssss.>>?????.."+getProductList);
		return getProductList;
	}
	
	@Override
	public List<Map<String, Object>> getCarsComments(String id) throws DataAccessException {
		System.out.println("inside getDetailsPic list..");
		
		String query = "select * from user_data.carcomment where itemId='"+id+"'";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getDetailsComments listsssssss.>>?????.."+getProductList);
		return getProductList;
	}
	
	@Override
	public List<Map<String, Object>> getRestroComments(String id) throws DataAccessException {
		System.out.println("inside getDetailsPic list..");
		
		String query = "select * from user_data.restrocomment where itemId='"+id+"'";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getDetailsComments listsssssss.>>?????.."+getProductList);
		return getProductList;
	}
	
	@Override
	public List<Map<String, Object>> getBlogComments(String id) throws DataAccessException {
		System.out.println("inside getDetailsPic list.."+id);
		
		String query = "select * from user_data.blogComment where itemId='"+id+"'";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getDetailsComments listsssssss.>>?????.."+getProductList);
		return getProductList;
	}
	
	@Override
	public List<Map<String, Object>> getDetailsBlogs() throws DataAccessException {
		System.out.println("inside getDetailsPic list..");
		
		String query = "select * from user_data.blog";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getDetailsComments listsssssss.>>?????.."+getProductList);
		return getProductList;
	}

	@Override
	public void addMovie(AddMovie addMovie, String path) {
		
		System.out.println("DAO addMovie");
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		   Calendar cal = Calendar.getInstance();
		   System.out.println(dateFormat.format(cal.getTime()));
	 
	
	
	String sql = "INSERT INTO user_data.movie(movie_name,actor_name,pic_path,comments,date) VALUES(?,?,?,?,?)";
	jdbcTemplate.update(sql, new Object[] { addMovie.getMoviename(),addMovie.getActName(),path,addMovie.getComment(),dateFormat.format(cal.getTime())});
	
	System.out.println("Done entries.>>>"+sql);
		
		
	}

	@Override
	public void addCars(AddCar addCar, String path1, String path2,
			String path3, String path4, String path5, String path6) {
		
		System.out.println("DAO addCars");
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		   Calendar cal = Calendar.getInstance();
		   System.out.println(dateFormat.format(cal.getTime()));
	 
	
	
	String sql = "INSERT INTO user_data.cars(car_name,model,price,path1,path2,path3,path4,path5,path6,comments) VALUES(?,?,?,?,?,?,?,?,?,?)";
	jdbcTemplate.update(sql, new Object[] { addCar.getCarName(),addCar.getModel(),addCar.getPrice(),path1,path2,path3,path4,path5,path6,addCar.getComment()});
	
	System.out.println("Done entries.>>>"+sql);
		
		
	}

	@Override
	public void addRestro(AddRestro addRestro, String path1, String path2,
			String path3, String path4, String path5, String path6) {
		System.out.println("addRestro addRestro");
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		   Calendar cal = Calendar.getInstance();
		   System.out.println(dateFormat.format(cal.getTime()));
	 
	
	
	String sql = "INSERT INTO user_data.restro(restro_name,location,timing,food,price,phone,path1,path2,path3,path4,path5,path6,comments,rating,totalComment) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	jdbcTemplate.update(sql, new Object[] { addRestro.getRestroName(),addRestro.getLocation(),addRestro.getTiming(),addRestro.getFoodtype(),addRestro.getPrice(),addRestro.getPhone(),path1,path2,path3,path4,path5,path6,addRestro.getComment(),0,0});
	
	System.out.println("Done entries.>>>"+sql);		
	}

	@Override
	public void addBlog(AddBlog addBlog, String path) {
		
		System.out.println("DAO addMovie");
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		   Calendar cal = Calendar.getInstance();
		   System.out.println(dateFormat.format(cal.getTime()));
	 
	
	
	String sql = "INSERT INTO user_data.blog(blog_name,path,comments,date) VALUES(?,?,?,?)";
	jdbcTemplate.update(sql, new Object[] { addBlog.getBlogname(),path,addBlog.getComment(),dateFormat.format(cal.getTime())});
	
	System.out.println("Done entries.>>>"+sql);
		
		
	}

	public void addUserBlog(AddUserBlog addBlog) {
		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");

		   Calendar cal = Calendar.getInstance();
		   System.out.println(dateFormat.format(cal.getTime()));
	 
	
	
	String sql = "INSERT INTO user_data.blogcomment(itemId,name,email,comments,date) VALUES(?,?,?,?,?)";
	jdbcTemplate.update(sql, new Object[] { addBlog.getComment_post_ID(),addBlog.getAuthor(), addBlog.getEmail(),addBlog.getComment(),dateFormat.format(cal.getTime())});
	
	System.out.println("Done entries.addComment>>>"+sql);		
	}

	@Override
	public List<Map<String, Object>> getCarsList() {
System.out.println("inside product list..");
		
		String query = "select * from user_data.cars";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList..."+getProductList);
		return getProductList;
	}

	@Override
	public List<Map<String, Object>> getRestroList() {
System.out.println("inside product list..");
		
		String query = "select * from user_data.restro";

		List<Map<String, Object>> getProductList = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList..."+getProductList);
		return getProductList;
	}

    @Override
    public void updateRestroComment(int value,int id,int tcomment) {
                System.out.println(id+"updateRestroComment.........."+value+"...................."+tcomment);
        String query = "update user_data.restro set rating ='"+value+"',totalComment='"+tcomment+"' where id='"+id+"'" ;
        jdbcTemplate.execute(query);
        System.out.println("update successfully");
    }

    @Override
    public List<Map<String, Object>> getTreandRestro() {
        System.out.println("updateRestroComment..............................");
        String query = "select * from user_data.restro where rating>=4";
        List<Map<String, Object>> getTreandRestro = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList..."+getTreandRestro);
		return getTreandRestro;
    }

    @Override
    public List<Map<String, Object>> searchRestro(RestroSearch rSearch) {
        System.out.println(rSearch.getName()+"=searchRestro..............................="+rSearch.getCity());
        String query="";
        if(rSearch.getCity().equals("select")){
            System.out.println("name is select");
              query = "select * from user_data.restro";
        }
        else{
         query = "select * from user_data.restro where location="+"'"+rSearch.getCity()+"'"+" && restro_name="+"'"+rSearch.getName()+"'";
            System.out.println(query);
        }
        List<Map<String, Object>> searchResult = jdbcTemplate.queryForList(query);	
		System.out.println("getProductList..."+searchResult);
		return searchResult;
    }

    @Override
    public List<Map<String, Object>> dropDownValueForRestro(String city) {
       System.out.println(city+"searchRestro..............................");
        String query = "select restro_name from user_data.restro where location='"+city+"'";
        List<Map<String, Object>> restroName = jdbcTemplate.queryForList(query);	
		System.out.println("restroName..."+restroName);
		return restroName;
    }


	
	
	
	
	

}
