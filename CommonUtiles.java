/**
 * 유틸 빈
 *
 */
@Component
public class Utils {
 
  /**
   * 쿠기값 가져오기
   * @param request
   * @param cookieName
   * @return
   */
  public String getCookies(HttpServletRequest request, String cookieName) {
    String value = null;
    Cookie[] cookies = request.getCookies();
    if(cookies == null) return value;
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals(cookieName)) {
        value = cookie.getValue();
        break;
      }
    }
    return value;
  }
 
  /**
   * 랜덤키 생성
   * 
   * @param size
   * @return
   */
  public String getKey(int size) {
    Random ran = new Random();
    StringBuffer sb = new StringBuffer();
    int num = 0;
    do {
      num = ran.nextInt(75) + 48;
      if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
        sb.append((char) num);
      } else {
        continue;
      }
    } while (sb.length() < size);
    return sb.toString();
  }
 
  /**
   * 아이피 주소 가져오기
   * @param request
   * @return
   */
  public String getIP(HttpServletRequest request) {
    String ip = request.getHeader("X-FORWARDED-FOR");
    // proxy 환경일 경우
    if (ip == null || ip.length() == 0) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    // 웹로직 서버일 경우
    if (ip == null || ip.length() == 0) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }
 
  /**
   * 브라우저 정보
   * @param request
   * @return
   */
  public String getBrowser(HttpServletRequest request) {
    String agent = request.getHeader("User-Agent");
    String browser = null;
    if (agent.indexOf("Trident") != -1 || agent.indexOf("MSIE") != -1) {
      browser = "IE";
    } else if (agent.indexOf("Opera") != -1) {
      browser = "Opera";
    } else if (agent.indexOf("Firefox") != -1) {
      browser = "Firefox";
    } else if (agent.indexOf("iPhone") != -1 && agent.indexOf("Mobile") != -1) {
      browser = "iPhone";
    } else if (agent.indexOf("Android") != -1 && agent.indexOf("Mobile") != -1) {
      browser = "Android";
    } else if (agent.indexOf("Safari") != -1) {
      if (agent.indexOf("Chrome") != -1) {
        browser = "Chrome";
      } else {
        browser = "Safari";
      }
    }else {
      browser = "";
    }
    return browser;
  }
 
  /**
   * os 정보
   * @param request
   * @return
   */
  public String getOs(HttpServletRequest request) {
    String agent = request.getHeader("User-Agent");
    String os = null;
    if(agent.indexOf("Windows") != -1) os = "Windows";
    else if(agent.indexOf("Linux") != -1) os = "Linux";
    else if(agent.indexOf("Macintosh") != -1) os = "Macintosh";
    else os = "";
    return os;
  }
   
}
