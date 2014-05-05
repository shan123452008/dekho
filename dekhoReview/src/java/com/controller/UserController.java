package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.user.*;
import com.validator.RegistrationValidator;

@Controller
public class UserController {

    @Autowired
    UserDao userdao;
    RegistrationValidator validator = new RegistrationValidator();
    HttpServletRequest request;
    HttpServletResponse response;

//    @RequestMapping(value = "/homePage.do")
//    public ModelAndView loginUser() {
//        System.out.println("Controller1");
//        ModelAndView userLogin = new ModelAndView("login");
//        userLogin.addObject("user", new User());
//        userLogin.addObject("userlist", userdao.userList());
//        return userLogin;
//    }
//    @RequestMapping(value = "/returnHomePage.do")
//    public ModelAndView homePage() {
//        ModelAndView home = new ModelAndView("homePage");
//        home.addObject("user", new User());
//        home.addObject("userlist", userdao.userList());
//        return home;
//    }

    //strt test
    @RequestMapping(value = "/blog.do", method = RequestMethod.GET)
    public String getUserBlog(HttpServletRequest req, HttpServletResponse response, ModelMap model) throws IOException, SQLException {
        HttpSession session = req.getSession();
        session.removeAttribute("blogDetails");

        StringBuilder detailsDiv = new StringBuilder();



        Map<String, Object> aeDataMap = null;
        Map<String, Object> dataMap = null;
        List<Map<String, Object>> getCommentList = userdao.getDetailsBlogs();

        System.out.println("get getCommentList lists>>>>>" + getCommentList);


        Iterator<Map<String, Object>> itrt = getCommentList.iterator();
        while (itrt.hasNext()) {
            dataMap = itrt.next();
            detailsDiv.append("<article class='format-standard'><div class='feature-image'><a href='blogInfo.do?pictureId=" + dataMap.get("id") + "'><img src='imagesPic/pictures/" + dataMap.get("path") + "' alt='Alt text'/></a></div><div class='box cf'><div class='entry-date'><div class='number'>" + dataMap.get("date") + "</div></div><div class='excerpt'><a href='single.html' class='post-heading'>" + dataMap.get("blog_name") + "</a><p></p></div><div class='meta'><span class='format'>Post</span><span class='user'><a href='#''>By </span><span class='comments'>16 comments</span></div></div></article>");

        }



        session.setAttribute("blogDetails", detailsDiv.toString());



        return "userBlog";

    }

    @RequestMapping(value = "/blogInfo.do", method = RequestMethod.GET)
    public String blogInfo(HttpServletRequest req, HttpServletResponse response, ModelMap model) throws IOException, SQLException {
        HttpSession session = req.getSession();
        session.removeAttribute("userRatingsBlog");
        session.removeAttribute("commentBlog");
        session.removeAttribute("detailsDivBlog");
        session.removeAttribute("haedingBlog");
        session.removeAttribute("userIdBlog");
        session.removeAttribute("detailsBlog");
        session.removeAttribute("detailsDivTextBlog");




        System.out.println("value of pic ID>>>>>>>>1>>>**))))))))))************" + req.getParameter("pictureId"));
        String picId = req.getParameter("pictureId");
        StringBuilder details = new StringBuilder();
        StringBuilder detailsDiv = new StringBuilder();
        StringBuilder detailsDivText = new StringBuilder();
        StringBuilder haeding = new StringBuilder();
        StringBuilder userId = new StringBuilder();
        StringBuilder comment = new StringBuilder();
        StringBuilder ratingDiv = new StringBuilder();



        System.out.println("picId>> dekh lo bhai....>>>---" + picId);

        if (picId == null) {
            System.out.println("andar gaya null me....<>>>>" + req.getSession().getAttribute("userBlogId").toString());
            picId = req.getSession().getAttribute("userBlogId").toString();

        }


        Map<String, Object> aeDataMap = null;
        Map<String, Object> dataMap = null;
        List<Map<String, Object>> getProductList = userdao.getBlogPic(picId);
        List<Map<String, Object>> getCommentList = userdao.getBlogComments(picId);
        System.out.println("get getProductList lists>>67>>>" + getProductList);
        System.out.println("getCommentList getCommentList lists>>69>>>" + getCommentList);



        Iterator<Map<String, Object>> itrt = getCommentList.iterator();
        while (itrt.hasNext()) {
            dataMap = itrt.next();
            comment.append("<li class='comment even thread-even depth-1' id='li-comment-4'><div id='comment-5' class='comment-body cf'><img alt='' src='http://0.gravatar.com/avatar/4f64c9f81bb0d4ee969aaf7b4a5a6f40?s=35&amp;d=&amp;r=G' class='avatar avatar-35 photo' height='35' width='35' /><div class='comment-author vcard'>" + dataMap.get("name") + "</div><div class='comment-meta commentmetadata'><span class='comment-date'><b>Date*</b>" + dataMap.get("date") + "</span></div><div class='comment-inner'><p>" + dataMap.get("comments") + "</p></div></div></li>");

        }


        Iterator<Map<String, Object>> itr = getProductList.iterator();
        while (itr.hasNext()) {
            aeDataMap = itr.next();
            System.out.println("iamge path before setting>>>>" + aeDataMap.get("path"));
            details.append("<img src='imagesPic/pictures/" + aeDataMap.get("path") + "' alt='Alt text' />");
            detailsDiv.append("<p><strong>Client </strong>" + aeDataMap.get("blog_name") + "</p><p><strong>Date </strong>" + aeDataMap.get("date") + "</p><p><a href='#' class='launch'>Launch Project</a></p>");
            detailsDivText.append("<p>" + aeDataMap.get("comments") + "</p>");
            haeding.append("<p>" + aeDataMap.get("blog_name") + "</p>");
            userId.append(picId);
        }


        session.setAttribute("userRatingsBlog", ratingDiv.toString());
        session.setAttribute("commentBlog", comment.toString());
        session.setAttribute("detailsDivTextBlog", detailsDiv.toString());
        session.setAttribute("haedingBlog", haeding.toString());
        session.setAttribute("userIdBlog", userId.toString());

        System.out.println("pic string....&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&7" + details.toString());

        session.setAttribute("detailsBlog", details.toString());
        session.setAttribute("detailsDivTextBlog", detailsDivText.toString());



        return "blogComment";

    }

    @RequestMapping(value = "/commentBlog.do", method = RequestMethod.POST)
    public String addBlog(@ModelAttribute("commentBlog") AddUserBlog addBlog, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();

        userdao.addUserBlog(addBlog);
        System.out.println("value of pic post>>>>>" + addBlog.getComment_post_ID());
        session.setAttribute("userBlogId", addBlog.getComment_post_ID());


        return "redirect:/blogInfo.do?pictureId=" + addBlog.getComment_post_ID() + "";
    }

    //Restro Section
    @RequestMapping(value = "/carRating.do", method = RequestMethod.GET)
    public String detailsCarsRating(HttpServletRequest req, HttpServletResponse response, ModelMap model) throws IOException, SQLException {
        HttpSession session = req.getSession();
        session.removeAttribute("carsRating");
        session.removeAttribute("detailsCars");
        session.removeAttribute("heading");
        session.removeAttribute("detailCar");
        session.removeAttribute("comment");


        System.out.println("value of pic ID>>>>>>>>1>>>**************" + req.getParameter("carId"));
        StringBuilder details = new StringBuilder();
        StringBuilder detailsCars = new StringBuilder();
        StringBuilder heading = new StringBuilder();
        StringBuilder detailCar = new StringBuilder();
        StringBuilder comment = new StringBuilder();
        StringBuilder userId = new StringBuilder();




        String picId = req.getParameter("carId");
        if (picId == null) {
            System.out.println("andar gaya null me....<>>>>" + req.getSession().getAttribute("userCarId").toString());
            picId = req.getSession().getAttribute("userCarId").toString();

        }

        Map<String, Object> aeDataMap = null;
        Map<String, Object> dataMap = null;
        Map<String, Object> carDataMap = null;


        List<Map<String, Object>> getCarsList = userdao.getCarsDetails(picId);
        List<Map<String, Object>> getCommentList = userdao.getCarsComments(picId);


        System.out.println("cars details>>>>>++++>" + getCarsList);

        Iterator<Map<String, Object>> itrtt = getCommentList.iterator();
        int count = getCommentList.size();
        int rating = 0;
        while (itrtt.hasNext()) {
            carDataMap = itrtt.next();
            rating = rating + Integer.parseInt(carDataMap.get("ratings").toString());
            comment.append("<li class='comment even thread-even depth-1' id='li-comment-4'><div id='comment-5' class='comment-body cf'><img alt='' src='http://0.gravatar.com/avatar/4f64c9f81bb0d4ee969aaf7b4a5a6f40?s=35&amp;d=&amp;r=G' class='avatar avatar-35 photo' height='35' width='35' /><div class='comment-author vcard'>" + carDataMap.get("name") + "</div><div class='comment-meta commentmetadata'><span class='comment-date'><b>Rating*</b>" + carDataMap.get("ratings") + "</span></div><div class='comment-inner'><p>" + carDataMap.get("comments") + "</p></div></div></li>");

        }

        int userRating;
        if (rating != 0) {
            userRating = rating / count;
        } else {
            userRating = rating;
        }

        Iterator<Map<String, Object>> itr = getCarsList.iterator();
        while (itr.hasNext()) {
            aeDataMap = itr.next();
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path1") + "' alt='alt text' /></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path2") + "' alt='alt text' /></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path3") + "' alt='alt text' /></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path4") + "' alt='alt text' /></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path5") + "' alt='alt text' /></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path6") + "' alt='alt text' /></li>");

        }
        userId.append(picId);

        Iterator<Map<String, Object>> itrt = getCarsList.iterator();

        while (itrt.hasNext()) {
            dataMap = itrt.next();
            detailsCars.append("<p><strong>Car Name</strong>" + aeDataMap.get("car_name") + "</p><p><strong>Model </strong>" + aeDataMap.get("model") + "</p><p><strong>Price </strong>" + aeDataMap.get("price") + "</p><p><strong>Rating*** </strong>" + userRating + "</p>");
            heading.append("" + aeDataMap.get("car_name") + "");
            detailCar.append("" + aeDataMap.get("comments") + "");
        }
        session.setAttribute("carsRating", details.toString());
        session.setAttribute("comment", comment.toString());
        session.setAttribute("userId", userId.toString());


        session.setAttribute("detailsCars", detailsCars.toString());
        session.setAttribute("heading", heading.toString());
        session.setAttribute("detailCar", detailCar.toString());




        return "carsRating";
    }

    //End Restro Section
    @RequestMapping(value = "/restroRating.do", method = RequestMethod.GET)
    public ModelAndView detailsRestroRating(HttpServletRequest req, HttpServletResponse response, ModelMap model) throws IOException, SQLException {
        HttpSession session = req.getSession();
        session.removeAttribute("restroComment");
        session.removeAttribute("restrouserId");
        session.removeAttribute("detailsRestro");
        session.removeAttribute("headingRestro");
        session.removeAttribute("detailRestro");

        StringBuilder details = new StringBuilder();
        StringBuilder detailsCars = new StringBuilder();
        StringBuilder heading = new StringBuilder();
        StringBuilder detailCar = new StringBuilder();
        StringBuilder comment = new StringBuilder();
        StringBuilder userId = new StringBuilder();
        



        String picId = req.getParameter("restroId");
        if (picId == null) {
            System.out.println("andar gaya null me....<>>>>" + req.getSession().getAttribute("userRestroId").toString());
            picId = req.getSession().getAttribute("userRestroId").toString();

        }

        Map<String, Object> aeDataMap = null;
        Map<String, Object> dataMap = null;
        Map<String, Object> carDataMap = null;


        List<Map<String, Object>> getCarsList = userdao.getRestroDetails(picId);
        List<Map<String, Object>> getCommentList = userdao.getRestroComments(picId);


        System.out.println("cars details>>>>>++++>" + getCarsList);

        Iterator<Map<String, Object>> itrtt = getCommentList.iterator();
        int count = getCommentList.size();
        int rating = 0;
        while (itrtt.hasNext()) {
            carDataMap = itrtt.next();
            rating = rating + Integer.parseInt(carDataMap.get("ratings").toString());
            comment.append("<li class='comment even thread-even depth-1' id='li-comment-4'><div id='comment-5' class='comment-body cf'><img alt='' src='http://0.gravatar.com/avatar/4f64c9f81bb0d4ee969aaf7b4a5a6f40?s=35&amp;d=&amp;r=G' class='avatar avatar-35 photo' height='35' width='35' /><div class='comment-author vcard'>" + carDataMap.get("name") + "</div><div class='comment-meta commentmetadata'><span class='comment-date'><b>Rating*</b>" + carDataMap.get("ratings") + "</span></div><div class='comment-inner'><p>" + carDataMap.get("comments") + "</p></div></div></li>");

        }


        Iterator<Map<String, Object>> itr = getCarsList.iterator();
        while (itr.hasNext()) {
            aeDataMap = itr.next();
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path1") + "' alt='alt text' width='942' height='442'/></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path2") + "' alt='alt text' width='942' height='442'/></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path3") + "' alt='alt text' width='942' height='442'/></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path4") + "' alt='alt text' width='942' height='442'/></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path5") + "' alt='alt text' width='942' height='442'/></li>");
            details.append("<li><img src='imagesPic/pictures/" + aeDataMap.get("path6") + "' alt='alt text' width='942' height='442'/></li>");

        }
        userId.append(picId);

        Iterator<Map<String, Object>> itrt = getCarsList.iterator();

        while (itrt.hasNext()) {
            dataMap = itrt.next();
            detailsCars.append("<p><strong>Restaurant Name</strong>" + aeDataMap.get("restro_name") + "</p><p><strong>Location </strong>" + aeDataMap.get("location") + "</p><p><strong>timing </strong>" + aeDataMap.get("timing") + "</p><p><strong>Food </strong>" + aeDataMap.get("food") + "</p><p><strong>Rating*** </strong>" + aeDataMap.get("rating") + "</p>");
            heading.append("" + aeDataMap.get("restro_name") + "");
            detailCar.append("" + aeDataMap.get("comments") + "");
        }
        
//        session.setAttribute("restroRating", details.toString());
//        session.setAttribute("restroComment", comment.toString());
//        session.setAttribute("restrouserId", userId.toString());
//        session.setAttribute("detailsRestro", detailsCars.toString());
//        session.setAttribute("headingRestro", heading.toString());
//        session.setAttribute("detailRestro", detailCar.toString());
        StringBuilder HighRatingRestro1 =new StringBuilder();
List<Map<String, Object>> getTreandRestro = userdao.getTreandRestro();

 Map<String, Object> restroMap = null;
 Iterator<Map<String, Object>> itrtat1 = getTreandRestro.iterator();
        while (itrtat1.hasNext()) {
            restroMap = itrtat1.next();
            String ratings = restroMap.get("rating").toString();
            int loop = Integer.parseInt(ratings);
            String starImage = "";
            for (int i = 1; i <= loop; i++) {

                starImage = "<img src='images/icon_star.png'/>" + starImage;

            }

HighRatingRestro1.append("<li><div class='photo-box has-overlay biz-listing-photo'><a href='restroRating.do?restroId=" + restroMap.get("id") + "'><img width='180' height='180' src='imagesPic/pictures/" + restroMap.get("path1") + "' "
                    + "class='photo-box-img' alt='Flub A Dub Chub's'><div class=\"photo-box-overlay dynamic js-overlay\" style=\"bottom: -18px;\"><div class=\"clearfix\"><a data-hovercard-id=\"uDMennWqntxRjAzv6YyMXA\" href=restroRating.do?restroId=" + restroMap.get("id") + " class=\"biz-name\">" + restroMap.get("restro_name") + "</a><div class=\"biz-rating biz-rating-medium clearfix\">"
                    + "<div class=\"rating\">\n" +
"        <i title=\"4.0 star rating\" class=\"star-img stars_4\">\n" +
"            <img width=\"84\" height=\"303\" src='images/icon_star.png' class=\"offscreen\" alt=\"4.5 star rating\">\n" +
"        </i>\n" +
"    </div>\n" +
"\n" +
"\n" +
"                <span class=\"review-count rating-qualifier\">\n" +
"   " + restroMap.get("totalComment") + " reviews \n" +
"    </span>\n" +
"\n" +
"        </div>\n" +
"\n" +
"            </div>\n" +
"                <div class=\"additional-info js-hidden-info\">\n" +
"                            <span class=\"neighborhood-str-list\">\n" +
"            " + restroMap.get("location") + "\n" +
"        </span>\n" +
"\n" +
"                </div>\n" +
"        </div>\n" +
"            <a href=restroRating.do?restroId=" + restroMap.get("id") + " class=\"biz-shim\">\n" +
"        <span class=\"offscreen\">Flub A Dub Chub’s</span>\n" +
"    </a>\n" +
"\n" +
       " </div>\n");

        }
       
        ModelAndView mv = null;
        mv = new ModelAndView("restroRating");
        mv.addObject("restroRating", details.toString());
        mv.addObject("restroComment", comment.toString());
        mv.addObject("restrouserId", userId.toString());
        mv.addObject("detailsRestro", detailsCars.toString());
        mv.addObject("headingRestro", heading.toString());
        mv.addObject("detailRestro", detailCar.toString());
        mv.addObject("HighRatingRestro1", HighRatingRestro1.toString());
        
        return mv;
    }

    //end test
    @RequestMapping(value = "/project.do", method = RequestMethod.GET)
    public String detailsProject(HttpServletRequest req, HttpServletResponse response, ModelMap model) throws IOException, SQLException {
        HttpSession session = req.getSession();
        session.removeAttribute("details");
        session.removeAttribute("detailsDiv");
        session.removeAttribute("detailsDivText");
        session.removeAttribute("haeding");
        session.removeAttribute("userId");
        session.removeAttribute("comment");
        session.removeAttribute("userRatings");




        System.out.println("value of pic ID>>>>>>>>1>>>**************" + req.getParameter("picId"));
        StringBuilder details = new StringBuilder();
        StringBuilder detailsDiv = new StringBuilder();
        StringBuilder detailsDivText = new StringBuilder();
        StringBuilder haeding = new StringBuilder();
        StringBuilder userId = new StringBuilder();
        StringBuilder comment = new StringBuilder();
        StringBuilder ratingDiv = new StringBuilder();
        String picId = req.getParameter("picId");


        System.out.println("picId>> dekh lo bhai....>>>---" + picId);

        if (picId == null) {
            System.out.println("andar gaya null me....<>>>>" + req.getSession().getAttribute("userId").toString());
            picId = req.getSession().getAttribute("userId").toString();

        }


        Map<String, Object> aeDataMap = null;
        Map<String, Object> dataMap = null;
        List<Map<String, Object>> getProductList = userdao.getDetailsPic(req.getParameter("picId"));
        List<Map<String, Object>> getCommentList = userdao.getDetailsComments(req.getParameter("picId"));

        System.out.println("get getCommentList lists>>>>>" + getCommentList);


        Iterator<Map<String, Object>> itrt = getCommentList.iterator();
        int count = getCommentList.size();
        int rating = 0;
        while (itrt.hasNext()) {
            dataMap = itrt.next();
            rating = rating + Integer.parseInt(dataMap.get("ratings").toString());
            comment.append("<li class='comment even thread-even depth-1' id='li-comment-4'><div id='comment-5' class='comment-body cf'><img alt='' class='avatar avatar-35 photo' height='35' width='35' /><div class='comment-author vcard'>" + dataMap.get("name") + "</div><div class='comment-meta commentmetadata'><span class='comment-date'><b>Rating*</b>" + dataMap.get("ratings") + "</span></div><div class='comment-inner'><p>" + dataMap.get("comments") + "</p></div></div></li>");

        }


        Iterator<Map<String, Object>> itr = getProductList.iterator();
        while (itr.hasNext()) {
            aeDataMap = itr.next();
            details.append("<img src='imagesPic/pictures/" + aeDataMap.get("pic_path") + "' alt='Alt text' />");
            //detailsDiv.append( "<p><strong>Client </strong>"+aeDataMap.get("name")+"</p><p><strong>Date </strong>"+aeDataMap.get("date")+"</p><p><a href='#' class='launch'>Launch Project</a></p>" );
            detailsDivText.append("<p>" + aeDataMap.get("comments") + "</p>");
            haeding.append("<p>" + aeDataMap.get("name") + "</p>");
            userId.append(req.getParameter("picId"));
        }

        int userRating;
        if (rating != 0) {
            userRating = rating / count;
        } else {
            userRating = rating;
        }

        ratingDiv.append("<div class='entry-date'><div class='number'>Rating</div><div class='month'>" + userRating + "</div></div>");

        System.out.println("rating count>>>>00000>>>>" + rating);
        System.out.println("comment size count>>>>00000>>>>" + count);

        session.setAttribute("userRatings", ratingDiv.toString());
        session.setAttribute("comment", comment.toString());
        session.setAttribute("detailsDiv", detailsDiv.toString());
        session.setAttribute("haeding", haeding.toString());
        session.setAttribute("userId", userId.toString());

        session.setAttribute("details", details.toString());
        session.setAttribute("detailsDivText", detailsDivText.toString());



        return "single";

    }

    @RequestMapping(value = "/carsCommentAdd.do", method = RequestMethod.POST)
    public String addCarComment(@ModelAttribute("commntCarAdd") AddCarComment addCarComment, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();

        userdao.addCarComment(addCarComment);
        System.out.println("value of pic post>>>>%%%%>" + addCarComment.getComment_post_ID());
        session.setAttribute("userCarId", addCarComment.getComment_post_ID());


        return "redirect:/carRating.do?userCarId=" + addCarComment.getComment_post_ID() + "";
    }

    @RequestMapping(value = "/restroCommentAdd.do", method = RequestMethod.POST)
    public String addRestroComment(@ModelAttribute("commntCarAdd") AddRestroComment addRestroComment, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();

        userdao.addRestroComment(addRestroComment);
        System.out.println("value of pic post>>>>%%%%>" + addRestroComment.getComment_post_ID());
        session.setAttribute("userRestroId", addRestroComment.getComment_post_ID());

        //prashant pallav 
        Map<String, Object> carDataMap = null;

        List<Map<String, Object>> getCommentList = userdao.getRestroComments(addRestroComment.getComment_post_ID());

        Iterator<Map<String, Object>> itrtt = getCommentList.iterator();
        int count = getCommentList.size();
        System.out.println("commentlist.size========"+count);
        int rating = 0;
        while (itrtt.hasNext()) {
            carDataMap = itrtt.next();
            rating = rating + Integer.parseInt(carDataMap.get("ratings").toString());

        }

        int userRating;
        if (rating != 0) {
            userRating = rating / count;
        } else {
            userRating = rating;
        }
        userdao.updateRestroComment(userRating,count ,Integer.parseInt(addRestroComment.getComment_post_ID()));


        //ends here

        return "redirect:/restroRating.do?userRestroId=" + addRestroComment.getComment_post_ID() + "";
    }

    @RequestMapping(value = "/commentAdd.do", method = RequestMethod.POST)
    public String addComment(@ModelAttribute("commntAdd") AddComment addComment, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();

        userdao.addComment(addComment);
        System.out.println("value of pic post>>>>>" + addComment.getComment_post_ID());
        session.setAttribute("userId", addComment.getComment_post_ID());


        return "redirect:/project.do?picId=" + addComment.getComment_post_ID() + "";
    }

    @RequestMapping(value = "/movie.do", method = RequestMethod.POST)
    public String addMovie(@ModelAttribute("movie") AddMovie addMovie, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Controller32");

        HttpSession session = req.getSession();

        String path;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        System.out.println("inputStream..." + inputStream);

        String useSession = req.getSession().getServletContext().getRealPath("/imagesPic");
        System.out.println("useSession.." + useSession);

        MultipartFile file = addMovie.getUploadImage();
        System.out.println("filess..." + file);
        String fileName = file.getOriginalFilename();
        File newFile = new File(useSession + "/pictures/" + fileName);
        // File newFile = new File("D:/INDIA_ONLINE_PROJECT_PICTUES/" + fileName);
        path = file.getOriginalFilename().toString();

        inputStream = file.getInputStream();

        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream = new FileOutputStream(newFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read = 0;
        byte[] bytes = new byte[1024];

        try {
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("path>>>>->..." + path);


        if (result.hasErrors()) {
            return "login";
        } else {
            userdao.addMovie(addMovie, path);
        }


        return "signInUser";

    }

    @RequestMapping(value = "/cars.do", method = RequestMethod.POST)
    public String addCars(@ModelAttribute("cars") AddCar addCar, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Controller32");

        HttpSession session = req.getSession();

        String path1;
        String path2;
        String path3;
        String path4;
        String path5;
        String path6;
        InputStream inputStream1 = null;
        InputStream inputStream2 = null;
        InputStream inputStream3 = null;
        InputStream inputStream4 = null;
        InputStream inputStream5 = null;
        InputStream inputStream6 = null;

        OutputStream outputStream1 = null;
        OutputStream outputStream2 = null;
        OutputStream outputStream3 = null;
        OutputStream outputStream4 = null;
        OutputStream outputStream5 = null;
        OutputStream outputStream6 = null;

        String useSession = req.getSession().getServletContext().getRealPath("/imagesPic");
        System.out.println("useSession.." + useSession);

        MultipartFile file1 = addCar.getUploadImage1();
        MultipartFile file2 = addCar.getUploadImage2();
        MultipartFile file3 = addCar.getUploadImage3();
        MultipartFile file4 = addCar.getUploadImage4();
        MultipartFile file5 = addCar.getUploadImage5();
        MultipartFile file6 = addCar.getUploadImage6();
        System.out.println("filess...1" + file1 + "file2>" + file2);
        String fileName1 = file1.getOriginalFilename();
        String fileName2 = file2.getOriginalFilename();
        String fileName3 = file3.getOriginalFilename();
        String fileName4 = file4.getOriginalFilename();
        String fileName5 = file5.getOriginalFilename();
        String fileName6 = file6.getOriginalFilename();
        File newFile1 = new File(useSession + "/pictures/" + fileName1);
        File newFile2 = new File(useSession + "/pictures/" + fileName2);
        File newFile3 = new File(useSession + "/pictures/" + fileName3);
        File newFile4 = new File(useSession + "/pictures/" + fileName4);
        File newFile5 = new File(useSession + "/pictures/" + fileName5);
        File newFile6 = new File(useSession + "/pictures/" + fileName6);
        // File newFile = new File("D:/INDIA_ONLINE_PROJECT_PICTUES/" + fileName);
        path1 = file1.getOriginalFilename().toString();
        path2 = file2.getOriginalFilename().toString();
        path3 = file3.getOriginalFilename().toString();
        path4 = file4.getOriginalFilename().toString();
        path5 = file5.getOriginalFilename().toString();
        path6 = file6.getOriginalFilename().toString();




        inputStream1 = file1.getInputStream();
        inputStream2 = file2.getInputStream();
        inputStream3 = file3.getInputStream();
        inputStream4 = file4.getInputStream();
        inputStream5 = file5.getInputStream();
        inputStream6 = file6.getInputStream();


        if (!newFile1.exists()) {
            try {
                newFile1.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream1 = new FileOutputStream(newFile1);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read = 0;
        byte[] bytes = new byte[1024];

        try {
            while ((read = inputStream1.read(bytes)) != -1) {
                outputStream1.write(bytes, 0, read);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //2
        if (!newFile2.exists()) {
            try {
                newFile2.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream2 = new FileOutputStream(newFile2);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read2 = 0;
        byte[] bytes2 = new byte[1024];

        try {
            while ((read2 = inputStream2.read(bytes2)) != -1) {
                outputStream2.write(bytes2, 0, read2);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //3

        if (!newFile3.exists()) {
            try {
                newFile3.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream3 = new FileOutputStream(newFile3);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read3 = 0;
        byte[] bytes3 = new byte[1024];

        try {
            while ((read3 = inputStream3.read(bytes3)) != -1) {
                outputStream3.write(bytes3, 0, read3);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //4
        if (!newFile4.exists()) {
            try {
                newFile4.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream4 = new FileOutputStream(newFile4);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read4 = 0;
        byte[] bytes4 = new byte[1024];

        try {
            while ((read4 = inputStream4.read(bytes4)) != -1) {
                outputStream4.write(bytes4, 0, read4);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //5

        if (!newFile5.exists()) {
            try {
                newFile5.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream5 = new FileOutputStream(newFile5);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read5 = 0;
        byte[] bytes5 = new byte[1024];

        try {
            while ((read5 = inputStream5.read(bytes5)) != -1) {
                outputStream5.write(bytes5, 0, read5);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //6

        if (!newFile6.exists()) {
            try {
                newFile6.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream6 = new FileOutputStream(newFile6);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read6 = 0;
        byte[] bytes6 = new byte[1024];

        try {
            while ((read6 = inputStream6.read(bytes6)) != -1) {
                outputStream6.write(bytes6, 0, read6);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("path>>>1>->..." + path1 + "path>>>2>->..." + path2 + "path>>>3>->..." + path3 + "path>>>4>->..." + path4 + "path>>>5>->..." + path5 + "path>>>6>->..." + path6);


        if (result.hasErrors()) {
            return "login";
        } else {
            userdao.addCars(addCar, path1, path2, path3, path4, path5, path6);
        }


        return "signInUser";
    }

    @RequestMapping(value = "/restro.do", method = RequestMethod.POST)
    public String addRestro(@ModelAttribute("restro") AddRestro addRestro, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Controller32");

        HttpSession session = req.getSession();

        String path1;
        String path2;
        String path3;
        String path4;
        String path5;
        String path6;
        InputStream inputStream1 = null;
        InputStream inputStream2 = null;
        InputStream inputStream3 = null;
        InputStream inputStream4 = null;
        InputStream inputStream5 = null;
        InputStream inputStream6 = null;

        OutputStream outputStream1 = null;
        OutputStream outputStream2 = null;
        OutputStream outputStream3 = null;
        OutputStream outputStream4 = null;
        OutputStream outputStream5 = null;
        OutputStream outputStream6 = null;

        String useSession = req.getSession().getServletContext().getRealPath("/imagesPic");
        System.out.println("useSession.." + useSession);

        MultipartFile file1 = addRestro.getUploadImage1();
        MultipartFile file2 = addRestro.getUploadImage2();
        MultipartFile file3 = addRestro.getUploadImage3();
        MultipartFile file4 = addRestro.getUploadImage4();
        MultipartFile file5 = addRestro.getUploadImage5();
        MultipartFile file6 = addRestro.getUploadImage6();
        System.out.println("filess...1" + file1 + "file2>" + file2);
        String fileName1 = file1.getOriginalFilename();
        String fileName2 = file2.getOriginalFilename();
        String fileName3 = file3.getOriginalFilename();
        String fileName4 = file4.getOriginalFilename();
        String fileName5 = file5.getOriginalFilename();
        String fileName6 = file6.getOriginalFilename();
        File file = new File(useSession + "\\pictures");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        File newFile1 = new File(useSession + "/pictures/" + fileName1);
        File newFile2 = new File(useSession + "/pictures/" + fileName2);
        File newFile3 = new File(useSession + "/pictures/" + fileName3);
        File newFile4 = new File(useSession + "/pictures/" + fileName4);
        File newFile5 = new File(useSession + "/pictures/" + fileName5);
        File newFile6 = new File(useSession + "/pictures/" + fileName6);
        // File newFile = new File("D:/INDIA_ONLINE_PROJECT_PICTUES/" + fileName);
        path1 = file1.getOriginalFilename().toString();
        path2 = file2.getOriginalFilename().toString();
        path3 = file3.getOriginalFilename().toString();
        path4 = file4.getOriginalFilename().toString();
        path5 = file5.getOriginalFilename().toString();
        path6 = file6.getOriginalFilename().toString();




        inputStream1 = file1.getInputStream();
        inputStream2 = file2.getInputStream();
        inputStream3 = file3.getInputStream();
        inputStream4 = file4.getInputStream();
        inputStream5 = file5.getInputStream();
        inputStream6 = file6.getInputStream();


        if (!newFile1.exists()) {
            try {
                newFile1.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream1 = new FileOutputStream(newFile1);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read = 0;
        byte[] bytes = new byte[1024];

        try {
            while ((read = inputStream1.read(bytes)) != -1) {
                outputStream1.write(bytes, 0, read);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //2
        if (!newFile2.exists()) {
            try {
                newFile2.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream2 = new FileOutputStream(newFile2);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read2 = 0;
        byte[] bytes2 = new byte[1024];

        try {
            while ((read2 = inputStream2.read(bytes2)) != -1) {
                outputStream2.write(bytes2, 0, read2);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //3

        if (!newFile3.exists()) {
            try {
                newFile3.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream3 = new FileOutputStream(newFile3);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read3 = 0;
        byte[] bytes3 = new byte[1024];

        try {
            while ((read3 = inputStream3.read(bytes3)) != -1) {
                outputStream3.write(bytes3, 0, read3);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //4
        if (!newFile4.exists()) {
            try {
                newFile4.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream4 = new FileOutputStream(newFile4);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read4 = 0;
        byte[] bytes4 = new byte[1024];

        try {
            while ((read4 = inputStream4.read(bytes4)) != -1) {
                outputStream4.write(bytes4, 0, read4);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //5

        if (!newFile5.exists()) {
            try {
                newFile5.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream5 = new FileOutputStream(newFile5);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read5 = 0;
        byte[] bytes5 = new byte[1024];

        try {
            while ((read5 = inputStream5.read(bytes5)) != -1) {
                outputStream5.write(bytes5, 0, read5);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //6

        if (!newFile6.exists()) {
            try {
                newFile6.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream6 = new FileOutputStream(newFile6);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read6 = 0;
        byte[] bytes6 = new byte[1024];

        try {
            while ((read6 = inputStream6.read(bytes6)) != -1) {
                outputStream6.write(bytes6, 0, read6);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("path>>>1>->..." + path1 + "path>>>2>->..." + path2 + "path>>>3>->..." + path3 + "path>>>4>->..." + path4 + "path>>>5>->..." + path5 + "path>>>6>->..." + path6);


        if (result.hasErrors()) {
            return "login";
        } else {
            userdao.addRestro(addRestro, path1, path2, path3, path4, path5, path6);
        }


        return "signInUser";
    }

    @RequestMapping(value = "/blog.do", method = RequestMethod.POST)
    public String addBlog(@ModelAttribute("blog") AddBlog addBlog, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();

        String path;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        System.out.println("inputStream..." + inputStream);

        String useSession = req.getSession().getServletContext().getRealPath("/imagesPic");
        System.out.println("useSession.." + useSession);

        MultipartFile file = addBlog.getUploadImage();
        System.out.println("filess..." + file);
        String fileName = file.getOriginalFilename();
        File newFile = new File(useSession + "/pictures/" + fileName);
        // File newFile = new File("D:/INDIA_ONLINE_PROJECT_PICTUES/" + fileName);
        path = file.getOriginalFilename().toString();

        inputStream = file.getInputStream();

        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream = new FileOutputStream(newFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read = 0;
        byte[] bytes = new byte[1024];

        try {
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("path>>>>->..." + path);


        if (result.hasErrors()) {
            return "login";
        } else {
            userdao.addBlog(addBlog, path);
        }


        return "signInUser";
    }

    //End New coding
    /*
    @RequestMapping(value = "/project.do")
    public ModelAndView project() {
    ModelAndView project = new ModelAndView("project");
    project.addObject("user", new User());
    project.addObject("userlist", userdao.userList());
    return project;
    }*/
    @RequestMapping(value = "/restro.do")
    public ModelAndView hotel() {
        System.out.println("Controller1");
        ModelAndView hotel = new ModelAndView("restaurants");
        return hotel;
    }

    @RequestMapping(value = "/contactUs.do")
    public ModelAndView contact() {
        ModelAndView contact = new ModelAndView("contact");
        return contact;
    }

    @RequestMapping(value = "/about.do")
    public ModelAndView about() {
        ModelAndView about = new ModelAndView("about");
        return about;
    }

    @RequestMapping(value = "/loginUser.do", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User loginUser, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {


        System.out.println("Controller2");

        HttpSession session = req.getSession();

        String path;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        System.out.println("inputStream..." + inputStream);

        String useSession = req.getSession().getServletContext().getRealPath("/imagesPic");
        System.out.println("useSession.." + useSession);

        MultipartFile file = loginUser.getUploadImage();
        System.out.println("filess..." + file);
        String fileName = file.getOriginalFilename();
        File newFile = new File(useSession + "/pictures/" + fileName);
        // File newFile = new File("D:/INDIA_ONLINE_PROJECT_PICTUES/" + fileName);
        path = file.getOriginalFilename().toString();

        inputStream = file.getInputStream();

        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputStream = new FileOutputStream(newFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int read = 0;
        byte[] bytes = new byte[1024];

        try {
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("path>>>>->..." + path);


        if (result.hasErrors()) {
            return "login";
        } else {
            userdao.addUser(loginUser, path);
        }


        return "signInUser";
    }

    /*Testing*/
    @RequestMapping(value = "/details.do", method = RequestMethod.GET)
    public String details(HttpServletRequest req,
            HttpServletResponse response, ModelMap model) throws IOException, SQLException {
        HttpSession session = req.getSession();
        session.removeAttribute("citationDiv");

        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        Writer out;
        out = response.getWriter();
        StringBuilder picDetails = new StringBuilder();
        Map<String, Object> aeDataMap = null;
        List<Map<String, Object>> getProductList = userdao.getDetailsList();

        System.out.println("session...>>" + session);
        Iterator<Map<String, Object>> itr = getProductList.iterator();
        while (itr.hasNext()) {
            aeDataMap = itr.next();
            // to identify the record uniquely on the bases of : ID.						

            // citationDiv.append( "<article class='item thumb' data-width='282'><h2>You really got me</h2><a href='imagesPic/pictures/"+aeDataMap.get("pic_path")+"'><img src='imagesPic/pictures/"+aeDataMap.get("pic_path")+"' alt=''></a></article>" );
            System.out.println("image paths????>>>" + aeDataMap.get("pic_path"));
            //System.out.println("string ...???>>>"+citationDiv.toString());

            picDetails.append("<article class='item thumb' data-width='500'><h2>" + aeDataMap.get("comments") + " -" + aeDataMap.get("name") + "</h2><a href='imagesPic/pictures/" + aeDataMap.get("pic_path") + "'><img src='imagesPic/pictures/" + aeDataMap.get("pic_path") + "' alt=''></a></article>");

        }
        out.write(picDetails.toString());
        System.out.println("");
        session.setAttribute("citationDiv", picDetails.toString());
        req.setAttribute("citationDiv", picDetails.toString());




        return "signInUser";
    } // ends : agencyDash() 

    @RequestMapping(value = "/category.do", method = RequestMethod.POST)
    public String category(@ModelAttribute("category") PostCategory category, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();

        String post = category.getPostProduct();
        String redirect;

        System.out.println("Post product>>>>" + post);

        if (post.equals("Cars")) {

            redirect = "cars";

        } else if (post.equals("Movie")) {
            redirect = "movie";

        } else if (post.equals("Restro")) {
            redirect = "restro";

        } else if (post.equals("Blog")) {
            redirect = "blog";


        } else {
            redirect = "signInUser";
        }

        return redirect;

    }

    //start
    @RequestMapping(value = "/homePage.do", method = RequestMethod.GET)
    public ModelAndView homePage(HttpServletRequest req,
            HttpServletResponse response, ModelMap model) throws IOException, SQLException {
        HttpSession session = req.getSession();
        session.removeAttribute("citationPic");
        session.removeAttribute("citation");


        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        Writer out;
        out = response.getWriter();
        StringBuilder picDetails = new StringBuilder();
        StringBuilder carDetails = new StringBuilder();
        StringBuilder restroDetails = new StringBuilder();
        StringBuilder HighRatingRestro = new StringBuilder();
        StringBuilder HighRatingRestro1 =new StringBuilder();
        StringBuilder newRestroDetails =new StringBuilder();
        
        Map<String, Object> aeDataMap = null;
        Map<String, Object> dataMap = null;
        Map<String, Object> restroMap = null;

        List<Map<String, Object>> getProductList = userdao.getDetailsList();
        List<Map<String, Object>> getCarList = userdao.getCarsList();
        List<Map<String, Object>> getRestroList = userdao.getRestroList();
        List<Map<String, Object>> getTreandRestro = userdao.getTreandRestro();



        System.out.println("session...>>" + session);
        Iterator<Map<String, Object>> itr = getProductList.iterator();
        while (itr.hasNext()) {
            aeDataMap = itr.next();
            // to identify the record uniquely on the bases of : ID.						

            // citationDiv.append( "<article class='item thumb' data-width='282'><h2>You really got me</h2><a href='imagesPic/pictures/"+aeDataMap.get("pic_path")+"'><img src='imagesPic/pictures/"+aeDataMap.get("pic_path")+"' alt=''></a></article>" );
            System.out.println("image paths????>>>" + aeDataMap.get("pic_path"));
            //System.out.println("string ...???>>>"+citationDiv.toString());

            picDetails.append("<figure class='web' style='width: 200px; height: 270px;'><a href='project.do?picId=" + aeDataMap.get("id") + "' class='thumb'><img src='imagesPic/pictures/" + aeDataMap.get("pic_path") + "' title='' alt='alt'></a><figcaption><a href='#'><h4>" + aeDataMap.get("name") + "</h4></a>" + aeDataMap.get("comments") + "</figcaption></figure>");
//					details.append( " <li><img src='imagesPic/pictures/"+aeDataMap.get("pic_path")+"' alt='alt text' /></li>" );

        }
        out.write(picDetails.toString());

        Iterator<Map<String, Object>> itrt = getCarList.iterator();
        while (itrt.hasNext()) {
            dataMap = itrt.next();
            // to identify the record uniquely on the bases of : ID.						

            // citationDiv.append( "<article class='item thumb' data-width='282'><h2>You really got me</h2><a href='imagesPic/pictures/"+aeDataMap.get("pic_path")+"'><img src='imagesPic/pictures/"+aeDataMap.get("pic_path")+"' alt=''></a></article>" );
            System.out.println("image paths????>>>" + dataMap.get("path1"));
            //System.out.println("string ...???>>>"+citationDiv.toString());

            carDetails.append("<figure class='print'style='width: 200px; height: 270px;'><a href='carRating.do?carId=" + dataMap.get("id") + "' class='thumb'><img src='imagesPic/pictures/" + dataMap.get("path1") + "' title='' alt='alt'></a><figcaption><a href='#'><h4>" + dataMap.get("car_name") + "</h4></a>" + dataMap.get("model") + "</figcaption></figure>");
//						details.append( " <li><img src='imagesPic/pictures/"+aeDataMap.get("pic_path")+"' alt='alt text' /></li>" );

        }

        Iterator<Map<String, Object>> itrtat = getRestroList.iterator();
        while (itrtat.hasNext()) {
            restroMap = itrtat.next();
            String ratings = restroMap.get("rating").toString();
            int loop = Integer.parseInt(ratings);
            String starImage = "";
            for (int i = 1; i <= loop; i++) {

                starImage = "<img src='images/icon_star.png'/>" + starImage;

            }
            System.out.println("image paths????>>>" + restroMap.get("path1"));

            restroDetails.append("<figure class='design' style='width: 160px; height: 210px;'><a href='restroRating.do?restroId=" + restroMap.get("id") + "' class='thumb'><img src='imagesPic/pictures/" + restroMap.get("path1") + "' title='' alt='alt'></a><figcaption><a href='#'><h4>" + restroMap.get("restro_name") + "</h4></a>" + restroMap.get("location") + "<b><br>" + starImage + "</b></figcaption></figure>");
//						details.append( " <li><img src='imagesPic/pictures/"+aeDataMap.get("pic_path")+"' alt='alt text' /></li>" );
            //pallav test
            newRestroDetails.append("<li><div class='js-search-results js-place-results js-lock-on-load' style='opacity: 1;'>"
                    + "<div data-title='Corner Room' class='case js-case'><div class='image'><a href='restroRating.do?restroId=" + restroMap.get("id") + "' class='thumb'><img src='imagesPic/pictures/" + restroMap.get("path1") + "' title='' alt='alt'width=116&amp;height=89' style='margin-left: -6px;'></a>"
                    + "</div>"
                    + "<div class='text'><div class='text-cnt Restaurants'><a class='name' href='#'>" + restroMap.get("restro_name") + "</a>"
                    + "<p>" + restroMap.get("location") + " • Bethnal Green</p> </div><div class='text-stats'><span class='i-box'><span class='i-text'>Food</span>"
                    + "<span class='i-number i-number-red'>29</span></span><span class='i-box'><span class='i-text'>Decor</span><span class='i-number'>25</span>"
                    + "</span><span class='i-box'><span class='i-text'>Service</span><span class='i-number'>26</span></span>"
                    + "<span class='i-box'><span class='i-text'>Price</span><span class='i-number'>" + restroMap.get("price") + "</span></span></div>"
                    + "<div class='cl'>&nbsp;</div></div><div class='cl'>&nbsp;</div></div></div></li>");
            
            //pallav test ends here
        }



        //prashant for most rating restro
        Iterator<Map<String, Object>> itrtat1 = getTreandRestro.iterator();
        while (itrtat1.hasNext()) {
            restroMap = itrtat1.next();
            String ratings = restroMap.get("rating").toString();
            int loop = Integer.parseInt(ratings);
            String starImage = "";
            for (int i = 1; i <= loop; i++) {

                starImage = "<img src='images/icon_star.png'/>" + starImage;

            }
//            HighRatingRestro.append("<figure class='design'><a href='restroRating.do?restroId=" + restroMap.get("id") + "' class='thumb'><img src='imagesPic/pictures/" + restroMap.get("path1") + "' title='' alt='alt'></a><figcaption><a href='#'><h4>" + restroMap.get("restro_name") + "</h4></a>" + restroMap.get("location") + "<b><br>" + starImage + "</b></figcaption></figure>");
        HighRatingRestro1.append("<li><div class='photo-box has-overlay biz-listing-photo'><a href='restroRating.do?restroId=" + restroMap.get("id") + "'><img width='180' height='180' src='imagesPic/pictures/" + restroMap.get("path1") + "' "
                    + "class='photo-box-img' alt='Flub A Dub Chub's'><div class=\"photo-box-overlay dynamic js-overlay\" style=\"bottom: -18px;\"><div class=\"clearfix\"><a data-hovercard-id=\"uDMennWqntxRjAzv6YyMXA\" href=restroRating.do?restroId=" + restroMap.get("id") + " class=\"biz-name\">" + restroMap.get("restro_name") + "</a><div class=\"biz-rating biz-rating-medium clearfix\">"
                    + "<div class=\"rating\">\n" +
"        <i title=\"4.0 star rating\" class=\"star-img stars_4\">\n" +
"            <img width=\"84\" height=\"303\" src='images/icon_star.png' class=\"offscreen\" alt=\"4.5 star rating\">\n" +
"        </i>\n" +
"    </div>\n" +
"\n" +
"\n" +
"                <span class=\"review-count rating-qualifier\">\n" +
"           " + restroMap.get("totalComment") + " reviews \n" +
"    </span>\n" +
"\n" +
"        </div>\n" +
"\n" +
"            </div>\n" +
"                <div class=\"additional-info js-hidden-info\">\n" +
"                            <span class=\"neighborhood-str-list\">\n" +
"            " + restroMap.get("location") + "\n" +
"        </span>\n" +
"\n" +
"                </div>\n" +
"        </div>\n" +
"            <a href=restroRating.do?restroId=" + restroMap.get("id") + " class=\"biz-shim\">\n" +
"        <span class=\"offscreen\">Flub A Dub Chub’s</span>\n" +
"    </a>\n" +
"\n" +
       " </div>\n");

        }
        //ends here most rating

        System.out.println("picDetails>>>>>>>>>>-----???" + picDetails);
        session.setAttribute("citation", picDetails.toString());
        session.setAttribute("carDetails", carDetails.toString().replaceAll("\n", "<br>"));
        session.setAttribute("restroDetails", restroDetails.toString().replaceAll("\n", "<br>"));

        //	session.setAttribute("details", details.toString());

        req.setAttribute("citationDiv", picDetails.toString());
        ModelAndView mv = new ModelAndView();

        mv.addObject("restroDetails", restroDetails.toString());
        mv.addObject("HighRatingRestro", HighRatingRestro1.toString());
        
        if (req.getParameter("help").equals("index")) {
            mv.setViewName("index");
            return mv;
        } else {
           
            mv.setViewName("restaurantsList");
             mv.addObject("newRestroDetails", newRestroDetails.toString());
            return mv;
        }


        //  return "index";
    } // ends : agencyDash() 
    //end start

    @RequestMapping("picDetailsUser.do")
    public void accountChangesDiv() throws IOException, ParseException {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        Writer out;
        out = response.getWriter();
        StringBuilder picDetails = new StringBuilder();
        Map<String, Object> aeDataMap = null;
        List<Map<String, Object>> getProductList = userdao.getDetailsList();

        Iterator<Map<String, Object>> itr = getProductList.iterator();
        while (itr.hasNext()) {
            aeDataMap = itr.next();
            // to identify the record uniquely on the bases of : ID.						

            // citationDiv.append( "<article class='item thumb' data-width='282'><h2>You really got me</h2><a href='imagesPic/pictures/"+aeDataMap.get("pic_path")+"'><img src='imagesPic/pictures/"+aeDataMap.get("pic_path")+"' alt=''></a></article>" );
            System.out.println("image paths????>>>" + aeDataMap.get("pic_path"));
            //System.out.println("string ...???>>>"+citationDiv.toString());

            picDetails.append("<article class='item thumb' data-width='476'><h2>Kingdom of the Wind</h2><a href='imagesPic/pictures/" + aeDataMap.get("pic_path") + "'><img src='imagesPic/pictures/" + aeDataMap.get("pic_path") + "' alt=''></a></article>");

        }
        out.write(picDetails.toString());


    }

    /*End testing*/
    @RequestMapping("/delete/{userName}.do")
    public String deleteUser(@PathVariable String userName) {
        System.out.println("dfdfg");
        userdao.deleteUser(userName);
        return "redirect:/homePage.do";
    }

    @RequestMapping(value = "/deleteAll.do")
    public String deleteAll() {
        userdao.deleteUser();
        return "redirect:/homePage.do";
    }

    @RequestMapping("/editUser/{userName}.do")
    public ModelAndView editUser(@PathVariable String userName) {
        System.out.println("editUser/{userName}.do");
        User user = userdao.getUserRecord(userName);
        ModelAndView editUser = new ModelAndView("editUser");
        editUser.addObject("user", user);
        return editUser;
    }

    @RequestMapping("signInUpload.do")
    public ModelAndView signInUpload() {
        System.out.println("signInUser --2--sdfsdf-------do");

        List<Map<String, Object>> getProductList = userdao.getDetailsList();
        System.out.println("product list >>>>>>" + getProductList);
        ModelAndView usersignIn = new ModelAndView("signUp");
        return usersignIn;
    }

    @RequestMapping("signInUser.do")
    public ModelAndView signInUser() {
        System.out.println("signInUser --1--sdfsdf-------do");
        ModelAndView usersignIn = new ModelAndView("signIn");
        usersignIn.addObject("user", new User());
        return usersignIn;
    }

    @RequestMapping("picDetails.do")
    public String picDetails() throws IOException {

        PrintWriter out = null;

        StringBuffer savedCitationDiv = new StringBuffer();
        Map<String, Object> aeDataMap = null;
        StringBuffer citationDiv = new StringBuffer();
        String data;
        String testData = null;

        byte[] imageBytes;
        List<Map<String, Object>> getProductList = userdao.getDetailsList();
        System.out.println("product list..." + getProductList);
        // List<Map<String, Object>> featureServices = getUnsubscribedSevice();
        Iterator<Map<String, Object>> itr = getProductList.iterator();
        while (itr.hasNext()) {
            aeDataMap = itr.next();
            // to identify the record uniquely on the bases of : ID.						
					/* citationDiv.append( "<div class='li first row clearfix' style='cursor: pointer;'><div class='c-1 table-cell'><img alt='' src='resources/product_image/"+aeDataMap.get("PRODUCT_IMAGE")+"' height='83' width='111'></div><div class='second-column-container  table-cell'>"+aeDataMap.get("TITLE")+"</a></div>"
            +"<div class='third-column-container table-cell'><h3><a href='' title='blutooth bh320 - India''>"+aeDataMap.get("PRODUCT_TYPE")+"</a></h3></div>"
            +"<div class='third-column-container table-cell'><h4><a href='' style='text-decoration: none;'>"+aeDataMap.get("SUB_PRODUCT_TYPE")+"</a></h4></span></div>"
            +"<div class='fourth-column-container table-cell'>Rs "+aeDataMap.get("PRICE")+"</div></div><hr>" );	*/
            citationDiv.append("<article class='item thumb' data-width='282'><h2>You really got me</h2><a href='imagesPic/pictures/" + aeDataMap.get("pic_path") + "'><img src='imagesPic/pictures/" + aeDataMap.get("pic_path") + "' alt=''></a></article>");
            testData = "<article class='item thumb' data-width='282'><h2>You really got me</h2><a href='imagesPic/pictures/" + aeDataMap.get("pic_path") + "'><img src='imagesPic/pictures/" + aeDataMap.get("pic_path") + "' alt=''></a></article>";


        }

        System.out.println("details>>>>>-------" + citationDiv.toString());
        return testData;

    }

    @RequestMapping("signIn.do")
    public ModelAndView signIn(@ModelAttribute("user") User user,
            BindingResult result) {
        System.out.println("########3######");
        List<Map<String, Object>> getProductList = userdao.getDetailsList(user.getUserName());

        System.out.println("list for sign in.....>>" + getProductList);
        String password = null;
        String userPass;
        userPass = user.getPassWord();
        Iterator<Map<String, Object>> itr = getProductList.iterator();
        Map<String, Object> aeDataMap = null;

        while (itr.hasNext()) {
            aeDataMap = itr.next();
            password = aeDataMap.get("password").toString();
        }

        System.out.println("password before..." + password);
        System.out.println("userPass before..." + userPass);

        if (password.equals(userPass)) {
            System.out.println(" match passwrd...");
        } else {
            System.out.println("not match passwrd...");
        }



        ModelAndView usersignIn = new ModelAndView("postProduct");
        return usersignIn;

    }

    @RequestMapping(value = "/editUser/edit.do")
    public String editUser(@ModelAttribute("user") User editUser,
            BindingResult result) {
        System.out.println("edit.do");
        System.out.println("Controller");
        System.out.println("#################" + editUser.getPassWord());
        validator.validate(editUser, result);
        if (result.hasErrors()) {
            // return "editUser";
        } else {
            userdao.editUser(editUser);
        }
        return "redirect:/homePage.do";
    }

    @RequestMapping(value = "getUserName.do")
    @ResponseBody
    public String gerUserName(@RequestParam("value") String value) {
        System.out.println("Value is " + value);
        String userName;
        if (value == "") {
            userName = "Please Enter A value";
        } else {
            userName = userdao.getUserName(value).getUserName();
            System.out.println("UserName : " + userName);
            if (userName == null) {
                userName = "User Not Found";
            }
        }

        return userName;
    }

    @RequestMapping("/getUser.do")
    @ResponseBody
    public User getUser(@RequestParam("value") String userName) {
        System.out.println("editUser/{userName}.do");
        User user = userdao.getUserRecord(userName);
        return user;
    }

    @RequestMapping("/viewRestro.do")
    public ModelAndView restaurantsView() {
        System.out.println("pandey............");
        ModelAndView usersignIn = new ModelAndView("viewRestro");
        usersignIn.addObject("user", new User());

        return usersignIn;
    }
    // search Restraunt 

   @RequestMapping(value = "/restroSearch.do", method = RequestMethod.GET)
    public ModelAndView restroSearch(@ModelAttribute("searchRestro") RestroSearch restoObj, BindingResult result, SessionStatus status, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();
        System.out.println("value of pic post>>>>%%%%>" + restoObj.getCity());
        res.setHeader("Cache-Control", "no-cache");
        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");
        Writer out;
        out = res.getWriter();
        StringBuilder searchResult = new StringBuilder();
        StringBuilder HighRatingRestro = new StringBuilder();
        StringBuilder HighRatingRestro1 = new StringBuilder();
        Map<String, Object> restroMap = null;

        List<Map<String, Object>> getProductList = userdao.searchRestro(restoObj);

        List<Map<String, Object>> getTreandRestro = userdao.getTreandRestro();
        //prashant for most rating restro
        Iterator<Map<String, Object>> itrtat1 = getTreandRestro.iterator();
        while (itrtat1.hasNext()) {
            restroMap = itrtat1.next();
            String ratings = restroMap.get("rating").toString();
            int loop = Integer.parseInt(ratings);
            String starImage = "";
            for (int i = 1; i <= loop; i++) {

                starImage = "<img src='images/icon_star.png'/>" + starImage;

            }
            HighRatingRestro.append("<figure class='design'><a href='restroRating.do?restroId=" + restroMap.get("id") + "' class='thumb'><img src='imagesPic/pictures/" + restroMap.get("path1") + "' title='' alt='alt'></a><figcaption><a href='#'><h4>" + restroMap.get("restro_name") + "</h4></a>" + restroMap.get("location") + "<b><br>" + starImage + "</b></figcaption></figure>");
        
HighRatingRestro1.append("<li><div class='photo-box has-overlay biz-listing-photo'><a href='restroRating.do?restroId=" + restroMap.get("id") + "'><img width='180' height='180' src='imagesPic/pictures/" + restroMap.get("path1") + "' "
                    + "class='photo-box-img' alt='Flub A Dub Chub's'><div class=\"photo-box-overlay dynamic js-overlay\" style=\"bottom: -18px;\"><div class=\"clearfix\"><a data-hovercard-id=\"uDMennWqntxRjAzv6YyMXA\" href=restroRating.do?restroId=" + restroMap.get("id") + " class=\"biz-name\">" + restroMap.get("restro_name") + "</a><div class=\"biz-rating biz-rating-medium clearfix\">"
                    + "<div class=\"rating\">\n" +
"        <i title=\"4.0 star rating\" class=\"star-img stars_4\">\n" +
"            <img width=\"84\" height=\"303\" src='images/icon_star.png' class=\"offscreen\" alt=\"4.5 star rating\">\n" +
"        </i>\n" +
"    </div>\n" +
"\n" +
"\n" +
"                <span class=\"review-count rating-qualifier\">\n" +
"           " + restroMap.get("totalComment") + " reviews \n" +
"    </span>\n" +
"\n" +
"        </div>\n" +
"\n" +
"            </div>\n" +
"                <div class=\"additional-info js-hidden-info\">\n" +
"                            <span class=\"neighborhood-str-list\">\n" +
"            " + restroMap.get("location") + "\n" +
"        </span>\n" +
"\n" +
"                </div>\n" +
"        </div>\n" +
"            <a href=restroRating.do?restroId=" + restroMap.get("id") + " class=\"biz-shim\">\n" +
"        <span class=\"offscreen\">Flub A Dub Chub’s</span>\n" +
"    </a>\n" +
"\n" +
       " </div>\n");




}
        //ends here most rating


        System.out.println("pandey............222");
        Iterator<Map<String, Object>> itrtat = getProductList.iterator();
        while (itrtat.hasNext()) {
            restroMap = itrtat.next();
            String ratings = restroMap.get("rating").toString();
            int loop = Integer.parseInt(ratings);
            String starImage = "";
            for (int i = 1; i <= loop; i++) {

                starImage = "<img src='images/icon_star.png'/>" + starImage;

            }
            System.out.println("image paths????>>>" + restroMap.get("path1"));

      //      searchResult.append("<figure class='design' style='width: 200px; height: 270px;'><a href='restroRating.do?restroId=" + restroMap.get("id") + "' class='thumb'><img src='imagesPic/pictures/" + restroMap.get("path1") + "' title='' alt='alt'></a><figcaption><a href='#'><h4>" + restroMap.get("restro_name") + "</h4></a>" + restroMap.get("location") + "<b><br>" + starImage + "</b></figcaption></figure>");
// details.append( " <li><img src='imagesPic/pictures/"+aeDataMap.get("pic_path")+"' alt='alt text' /></li>" );
      
        
          searchResult.append("<div class='js-search-results js-place-results js-lock-on-load' style='opacity: 1;'>"
                    + "<div data-title='Corner Room' class='case js-case'><div class='image'><a href='restroRating.do?restroId=" + restroMap.get("id") + "' class='thumb'><img src='imagesPic/pictures/" + restroMap.get("path1") + "' title='' alt='alt'width=116&amp;height=89' style='margin-left: -6px;'></a>"
                    + "</div>"
                    + "<div class='text'><div class='text-cnt Restaurants'><a class='name' href='#'>" + restroMap.get("restro_name") + "</a>"
                    + "<p>" + restroMap.get("location") + " • Bethnal Green</p> </div><div class='text-stats'><span class='i-box'><span class='i-text'>Food</span>"
                    + "<span class='i-number i-number-red'>29</span></span><span class='i-box'><span class='i-text'>Decor</span><span class='i-number'>25</span>"
                    + "</span><span class='i-box'><span class='i-text'>Service</span><span class='i-number'>26</span></span>"
                    + "<span class='i-box'><span class='i-text'>Price</span><span class='i-number'>" + restroMap.get("price") + "</span></span></div>"
                    + "<div class='cl'>&nbsp;</div></div><div class='cl'>&nbsp;</div></div></div>");
        }
        ModelAndView usersignIn = null;
        String searchfrom = req.getParameter("searchfrom");
        if (searchfrom != null) {
            usersignIn = new ModelAndView("restaurantsList");
            usersignIn.addObject("newRestroDetails", searchResult);
            //usersignIn.addObject("HighRatingRestro", HighRatingRestro.toString());
            usersignIn.addObject("HighRatingRestro", HighRatingRestro1.toString());
        } else {
            out.write(searchResult.toString());

        }

        String sValue = searchResult.toString();
        System.out.println("pandey............");
//        ModelAndView usersignIn = new ModelAndView();
//        usersignIn.addObject("searchRestro", searchResult.toString());
//        usersignIn.setViewName("restaurantsList");
        return usersignIn;
    }

    @RequestMapping("/getRestroName.do")
    public ModelAndView getCarModelList(HttpServletRequest req, HttpServletResponse response) {

        try {
            StringBuilder data = new StringBuilder();
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            String restroID = req.getParameter("restroId");
            List getModelList = userdao.dropDownValueForRestro(restroID);
             data.append("<option value='select'>Set Name</option>");
            if (getModelList.size() > 0) {
                for (int i = 0; i < getModelList.size(); i++) {

                    Map m = (Map) getModelList.get(i);
                    data.append("<option value='" + m.get("restro_name") + "'>" + m.get("restro_name") + "</option>");
                }

            } else {
                data.append("<option value=''>Set Name</option>");
            }

            out.write(data.toString());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
