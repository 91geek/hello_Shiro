import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by wanglei on 16/8/7.
 */
public class MyRealm2 implements Realm {


    public String getName() {
        return "myRealm1";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("================!!!!!!!!!!!================");
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if (!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果密码错误
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        System.out.println("================2================");
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
