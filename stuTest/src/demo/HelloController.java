package demo;
import com.jfinal.core.Controller;
public class HelloController extends Controller {
    public void index() {
       renderText("Hello JFinal World.");
    }
    /**
     * 打开登录页面
     */
    public void openlogin() {
    	render("login.html");
    }
    /**
     * 登录
     */
    public void login() {
    	String username=getPara("username");
    	String password=getPara("password");
    	
    	String user="201704";
    	String pw="123";
    	
    	if(username.equals(user)) {
    		if(password.equals(pw)) {
    			setAttr("result", 0);//密码正确
    			renderJson();
    		}else {
    			setAttr("result", 1);//密码错误
    			renderJson();
    		}
    	}else {
    		setAttr("result", -1);//用户名不存在
			renderJson();
    	}
    }
    /**
     * 进入主页面
     */
    public void openmain() {
    	render("index.html");
    }
}