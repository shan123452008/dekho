package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.user.AddBlog;
import com.user.AddCar;
import com.user.AddCarComment;
import com.user.AddComment;
import com.user.AddMovie;
import com.user.AddRestro;
import com.user.AddRestroComment;
import com.user.AddUserBlog;
import com.user.User;
import com.user.RestroSearch;

public interface UserDao {

    public void addUser(User loginUser, String path);

    public void addMovie(AddMovie addMovie, String path);

    public void addCars(AddCar addCar, String path1, String path2, String path3, String path4, String path5, String path6);

    public void addRestro(AddRestro addRestro, String path1, String path2, String path3, String path4, String path5, String path6);

    public void addBlog(AddBlog addBlog, String path);

    public void addComment(AddComment addComment);

    public void addCarComment(AddCarComment addComment);

    public void addRestroComment(AddRestroComment addRestroComment);

    public List<User> userList();

    public List<Map<String, Object>> getDetailsPic(String string);

    public List<Map<String, Object>> getCarsDetails(String string);

    public List<Map<String, Object>> getRestroDetails(String string);

    public List<Map<String, Object>> getDetailsComments(String string);

    public List<Map<String, Object>> getCarsComments(String string);

    public List<Map<String, Object>> getRestroComments(String string);

    public void updateRestroComment(int value, int id ,int tComment);

    public List<Map<String, Object>> getDetailsList();

    public List<Map<String, Object>> getCarsList();

    public List<Map<String, Object>> getRestroList();
    public List<Map<String, Object>> getTreandRestro();

    public void deleteUser(String userName);

    public void deleteUser();

    public User getUserRecord(String userName);

    public User signIn(User user);

    public void editUser(User editUser);

    public User getUserName(String value);

    public List<Map<String, Object>> getDetailsList(String userName);

    List<Map<String, Object>> getDetailsBlogs() throws DataAccessException;

    List<Map<String, Object>> getBlogPic(String id) throws DataAccessException;

    List<Map<String, Object>> getBlogComments(String id)
            throws DataAccessException;

    public void addUserBlog(AddUserBlog addBlog);
    
    public List<Map<String, Object>> searchRestro(RestroSearch rSearch);
    
    public List<Map<String, Object>> dropDownValueForRestro(String city);
}
