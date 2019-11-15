/*
Navicat MySQL Data Transfer

Source Server         : link
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-11-15 17:41:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `article_sort_id` int(11) DEFAULT NULL,
  `article_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `article_content` text NOT NULL,
  `article_views` int(11) NOT NULL COMMENT '0',
  `article_createdTime` datetime NOT NULL,
  `article_updatedTime` datetime NOT NULL,
  `article_isPrivate` tinyint(6) NOT NULL COMMENT '1',
  `article_top` int(11) NOT NULL,
  `article_attachment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  KEY `article_ibfk_1` (`article_sort_id`),
  KEY `article_ibfk_2` (`user_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`article_sort_id`) REFERENCES `article_sort` (`article_sort_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('20', '1', '2', 'Python', '<span><span><span><p>Python,HHH</p></span><p><br></p></span><p><br></p></span><p><br></p>', '2', '2019-06-01 00:00:00', '2019-07-09 02:35:22', '0', '0', '\\attachment\\girl1.jpg');
INSERT INTO `article` VALUES ('21', '1', '2', 'afs', '<p>sgsdh</p>', '4', '2019-06-01 00:00:00', '2019-07-09 23:54:35', '0', '100', '\\attachment\\spring-1.jpeg');
INSERT INTO `article` VALUES ('22', '2', '2', 'Web开发', '<span><p>Web开发11</p></span><p><br></p>', '14', '2019-06-01 00:00:00', '2019-07-05 06:28:44', '0', '0', '\\attachment\\QQ截图20180421173530.png');
INSERT INTO `article` VALUES ('24', '2', '2', '真好', '<p>beautiful</p>', '0', '2019-06-01 00:56:44', '2019-07-05 04:35:28', '0', '0', '\\attachment\\u=222247294,2919493301&fm=27&gp=0.jpg');
INSERT INTO `article` VALUES ('25', '2', '2', '嘿嘿嘿', '<p>666</p>', '0', '2019-06-14 00:59:24', '2019-07-05 04:44:52', '0', '0', '\\attachment\\u=4206348751,4177014175&fm=27&gp=0.jpg');
INSERT INTO `article` VALUES ('26', '3', '2', 'SpringBoot+Mybatis注解方式实现关联查询', '<p>User实体类<br><br>```<br>package per.czt.pojo;<br><br>import org.springframework.boot.autoconfigure.domain.EntityScan;<br><br><br><br>public class User {<br>	private Integer user_id;<br><br>	private Town town;<br><br>	private String user_account;<br>	private String user_password;<br>	public Integer getUser_id() {<br>		return user_id;<br>	}<br><br>	public void setUser_id(Integer user_id) {<br>		this.user_id = user_id;<br>	}<br><br>	<br>	public Town getTown() {<br>		return town;<br>	}<br><br>	public void setTown(Town town) {<br>		this.town = town;<br>	}<br><br><br><br>	public String getUser_account() {<br>		return user_account;<br>	}<br><br>	public void setUser_account(String user_account) {<br>		this.user_account = user_account;<br>	}<br><br>	public String getUser_password() {<br>		return user_password;<br>	}<br><br>	public void setUser_password(String user_password) {<br>		this.user_password = user_password;<br>	}<br><br>	<br>	public User() {<br>		super();<br>		// TODO Auto-generated constructor stub<br>	}<br>	<br>	<br>	<br><br>}<br><br>```<br><br>Town实体类<br><br>```<br>package per.czt.pojo;<br><br>public class Town {<br>	private Integer town_id;<br>	private String town_name;<br>	/*private Integer city_id;*/<br>	private City city;<br>	public Integer getTown_id() {<br>		return town_id;<br>	}<br>	public void setTown_id(Integer town_id) {<br>		this.town_id = town_id;<br>	}<br>	public String getTown_name() {<br>		return town_name;<br>	}<br>	public void setTown_name(String town_name) {<br>		this.town_name = town_name;<br>	}<br>	<br>	public City getCity() {<br>		return city;<br>	}<br>	public void setCity(City city) {<br>		this.city = city;<br>	}<br>	public Town() {<br>		super();<br>		// TODO Auto-generated constructor stub<br>	}<br>	public Town(Integer town_id, String town_name, City city) {<br>		super();<br>		this.town_id = town_id;<br>		this.town_name = town_name;<br>		this.city = city;<br>	}<br>	<br>}<br><br>```<br>City实体类<br><br>```<br>package per.czt.pojo;<br><br>public class City {<br>	private Integer city_id;<br>	private String city_name;<br>	/*private Integer country_id;*/<br>	private Country country;<br>	public City() {<br>		super();<br>		// TODO Auto-generated constructor stub<br>	}<br>	public Integer getCity_id() {<br>		return city_id;<br>	}<br>	public void setCity_id(Integer city_id) {<br>		this.city_id = city_id;<br>	}<br>	public String getCity_name() {<br>		return city_name;<br>	}<br>	public void setCity_name(String city_name) {<br>		this.city_name = city_name;<br>	}<br>	public Country getCountry() {<br>		return country;<br>	}<br>	public void setCountry(Country country) {<br>		this.country = country;<br>	}<br>	public City(Integer city_id, String city_name, Country country) {<br>		super();<br>		this.city_id = city_id;<br>		this.city_name = city_name;<br>		this.country = country;<br>	}<br>	<br>}<br><br>```<br>UserMapper.xml文件<br><br>```<br>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;<br>&lt;!DOCTYPE mapper<br>PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"<br>\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"&gt;<br>&lt;mapper namespace=\"per.czt.mapper.UserMapper\"&gt;<br>&lt;/mapper&gt;<br>```<br>UserMapper接口<br><br>```<br>package per.czt.mapper;<br><br>import java.util.List;<br><br>import org.apache.ibatis.annotations.One;<br>import org.apache.ibatis.annotations.Result;<br>import org.apache.ibatis.annotations.Results;<br>import org.apache.ibatis.annotations.Select;<br><br>import per.czt.pojo.User;<br><br>public interface UserMapper {<br>	@Select(\"select * from user\")<br>	@Results({@Result(property=\"town\",column=\"town_id\",one=@One(select=\"per.czt.mapper.TownMapper.findTownById\"))})<br>	public List&lt;User&gt; searchAllUsers();<br><br>}<br><br>```<br>TownMapper.xml文件<br><br>```<br>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;<br>&lt;!DOCTYPE mapper<br>PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"<br>\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"&gt;<br>&lt;mapper namespace=\"per.czt.mapper.TownMapper\"&gt;<br>&lt;/mapper&gt;<br>```<br>TownMapper接口<br><br>```<br>package per.czt.mapper;<br><br>import org.apache.ibatis.annotations.One;<br>import org.apache.ibatis.annotations.Result;<br>import org.apache.ibatis.annotations.Results;<br>import org.apache.ibatis.annotations.Select;<br><br>import per.czt.pojo.Town;<br><br>public interface TownMapper {<br>	@Select(\"select * from town where town_id=#{town_id}\")<br>	@Results({@Result(column=\"city_id\",property=\"city\",one=@One(select=\"per.czt.mapper.CityMapper.findCityById\"))})<br>	public Town findTownById(Integer town_id);<br><br>}<br><br>```<br>CityMapper.xml文件<br><br>```<br>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;<br>&lt;!DOCTYPE mapper<br>PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"<br>\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"&gt;<br>&lt;mapper namespace=\"per.czt.mapper.CityMapper\"&gt;<br>&lt;/mapper&gt;<br>```<br>CityMapper接口<br><br>```<br>package per.czt.mapper;<br><br>import org.apache.ibatis.annotations.One;<br>import org.apache.ibatis.annotations.Result;<br>import org.apache.ibatis.annotations.Results;<br>import org.apache.ibatis.annotations.Select;<br><br>import per.czt.pojo.City;<br><br>public interface CityMapper {<br>	@Select(\"select * from city where city_id=#{city_id}\")<br>	public City findCityById(Integer city_id);<br>}<br><br>```<br>UserService接口<br><br>    package per.czt.service;<br>    <br>    import java.util.List;<br>    <br>    import per.czt.pojo.User;<br>    <br>    public interface UserService {<br>    	public List&lt;User&gt; searchAllUsers();<br>    <br>    }<br><br>UserServiceImpl 实现类<br><br>```<br>package per.czt.service.impl;<br><br>import java.util.List;<br><br>import org.springframework.beans.factory.annotation.Autowired;<br>import org.springframework.stereotype.Service;<br>import org.springframework.transaction.annotation.Transactional;<br><br>import per.czt.mapper.UserMapper;<br>import per.czt.pojo.User;<br>import per.czt.service.UserService;<br>@Service<br>@Transactional<br>public class UserServiceImpl implements UserService {<br>	@Autowired<br>	private UserMapper userMapper;<br><br>	@Override<br>	public List&lt;User&gt; searchAllUsers() {<br>		return userMapper.searchAllUsers();<br>	}<br><br>}<br><br>```<br>UserController<br><br>```<br>package per.czt.controller;<br><br>import java.util.List;<br><br>import org.springframework.beans.factory.annotation.Autowired;<br>import org.springframework.stereotype.Controller;<br>import org.springframework.ui.Model;<br>import org.springframework.web.bind.annotation.PathVariable;<br>import org.springframework.web.bind.annotation.RequestMapping;<br><br>import per.czt.pojo.User;<br>import per.czt.service.UserService;<br><br>@Controller<br>@RequestMapping(\"/user\")<br>public class UserController {<br>	@Autowired<br>	private UserService userService;<br>	<br>	<br>	@RequestMapping(\"/{page}\")<br>	public String showPage(@PathVariable String page) {<br>		return page;<br>	}<br>	@RequestMapping(\"/showAll\")<br>	public String showAllUsers(Model model) {<br>		<br>		<br>		List&lt;User&gt; userList=userService.searchAllUsers();<br>		model.addAttribute(\"userList\",userList);<br>		System.out.println(\"userList:\"+userList);<br>		for(User u:userList) {<br>			System.out.println(\"user_id:\"+u.getUser_id());<br>			System.out.println(\"user_account:\"+u.getUser_account());<br>			System.out.println(\"user_password:\"+u.getUser_password());<br>			System.out.println(\"user_profession:\"+u.getProfession());<br>			System.out.println(\"user_town:\"+u.getTown());<br>			System.out.println(\"user_town_id:\"+u.getTown().getTown_id());<br>			System.out.println(\"user_town_name:\"+u.getTown().getTown_name());<br>			System.out.println(\"user_city:\"+u.getTown().getCity());<br>			System.out.println(\"user_city_id:\"+u.getTown().getCity().getCity_id());<br>			System.out.println(\"user_city_name:\"+u.getTown().getCity().getCity_name())；<br>			System.out.println();<br>		}<br>		return \"userlist\";<br>	}<br>	<br>	<br><br>}<br><br>```<br>view层:userList.html，这里使用了thymeleaf模板<br><br>```<br>&lt;!DOCTYPE html &gt;<br>&lt;html xmlns:th=\"http://www.thymeleaf.org\"&gt;<br>&lt;head&gt;<br>&lt;meta charset=\"UTF-8\"/&gt;<br>&lt;title&gt;显示所有用户&lt;/title&gt;<br>&lt;/head&gt;<br>&lt;body&gt;<br>	&lt;table width=\"50%\" border=\"1\" align=\"center\"&gt;<br>		&lt;tr&gt;<br>			&lt;th&gt;用户ID&lt;/th&gt;<br>			&lt;th&gt;用户账号&lt;/th&gt;<br>			&lt;th&gt;用户密码&lt;/th&gt;<br>			&lt;th&gt;乡镇名称&lt;/th&gt;<br>			&lt;th&gt;城市名称&lt;/th&gt;<br>		&lt;/tr&gt;<br>		&lt;tr th:each=\"user:${userList}\"&gt;<br>			&lt;td th:text=\"${user.user_id}\"&gt;&lt;/td&gt;<br>			&lt;td th:text=\"${user.user_account}\"&gt;&lt;/td&gt;<br>			&lt;td th:text=\"${user.user_password}\"&gt;&lt;/td&gt;<br>			&lt;td th:text=\"${user.town.town_name}\"&gt;&lt;/td&gt;<br>			&lt;td th:text=\"${user.town.city.city_name}\"&gt;&lt;/td&gt;<br>		&lt;/tr&gt;<br>	<br>	&lt;/table&gt;<br>&lt;/body&gt;<br>&lt;/html&gt;<br>```<br>SpringBoot启动类<br><br>```<br>package per.czt;<br><br>import org.mybatis.spring.annotation.MapperScan;<br>import org.springframework.boot.SpringApplication;<br>import org.springframework.boot.autoconfigure.SpringBootApplication;<br><br>/**<br> * Hello world!<br> *<br> */<br>@SpringBootApplication<br>@MapperScan(\"per.czt.mapper\")<br>public class App <br>{<br>    public static void main( String[] args )<br>    {<br>        SpringApplication.run(App.class, args);<br>    }<br>}<br><br>```<br><br>运行结果<br>![在这里插入图片描述](https://img-blog.csdnimg.cn/20190623181613533.png)</p>', '0', '2019-07-02 01:50:58', '2019-07-02 01:50:58', '0', '0', '\\attachment\\9469669_142840860000_2.jpg');
INSERT INTO `article` VALUES ('27', '1', '2', '截取html页面的文章内容显示前一部分内容', '<p>如果展示一个列表，内容过长，样式就会错乱。如图：<br><br><br><br>更改后 ：<br><br><br><br>如何把长的内容截取指定的长度<br><br>1、&lt;table&nbsp; width=\"100%\"; style=\"table-layout: fixed;\"&gt;&nbsp;<br><br>2、&nbsp; &lt;th width=\"10%\"&gt;内容&lt;/th&gt;&nbsp; 这个是内容对应的title 给一个宽度就可以&nbsp;<br><br>3、&lt;td style=\"white-space:nowrap;overflow: hidden;text-overflow:ellipsis\"&gt;{$value[\'content\']}&lt;/td&gt;<br><br>就ok拉<br><br><br><br>方案二：<br><br><br><br><br><br>因为文字太长，显示乱板，则：使用一个标签就可以了 在内容里面加一个样式&nbsp; ，overflow:hidden;<br><br><br>--------------------- <br>作者：tianyuan_1 <br>来源：CSDN <br>原文：https://blog.csdn.net/tianyuan_1/article/details/79164095 <br>版权声明：本文为博主原创文章，转载请附上博文链接！</p>', '0', '2019-03-01 02:26:19', '2019-07-06 13:24:23', '0', '0', '\\attachment\\Capture001.png');
INSERT INTO `article` VALUES ('29', '1', '2', 'Java', '<p><br></p>', '0', '2018-10-01 03:13:38', '2018-11-01 09:13:50', '0', '0', '\\attachment\\girl1 - 副本.jpg');
INSERT INTO `article` VALUES ('32', '2', '2', '11', '<p>22</p>', '0', '2019-07-05 03:27:56', '2019-07-05 04:32:42', '0', '0', '\\attachment\\2345截图20181011130710.png');
INSERT INTO `article` VALUES ('34', '2', '2', 'Parameter \'xxx\' not found. Available parameters are [...]', '<p>mybatis注解开发时出现：Parameter ‘xxx’ not found. Available parameters are […]<br>解决方案：<br>在方法声明前加上@Param(“xxx”)&nbsp;&nbsp;<br></p>', '0', '2018-02-05 04:47:46', '2019-07-05 04:47:53', '0', '0', '\\attachment\\u=2962033657,4245604671&fm=27&gp=0.jpg');
INSERT INTO `article` VALUES ('35', '1', '2', '彻底弄懂UTF-8、Unicode、宽字符、locale', '<span><div><p>目录</p><div><ul><li><a href=\"https://www.cnblogs.com/gatsby123/p/11150472.html#unicodeucs\">Unicode、UCS</a></li><li><a href=\"https://www.cnblogs.com/gatsby123/p/11150472.html#utf8\">UTF8</a><ul><li><a href=\"https://www.cnblogs.com/gatsby123/p/11150472.html#%E7%BB%93%E8%AE%BA\">结论：</a></li></ul></li><li><a href=\"https://www.cnblogs.com/gatsby123/p/11150472.html#%E5%AE%BD%E5%AD%97%E7%AC%A6%E7%B1%BB%E5%9E%8Bwchar_t\">宽字符类型wchar_t</a><ul><li><a href=\"https://www.cnblogs.com/gatsby123/p/11150472.html#locale\">locale</a></li><li><a href=\"https://www.cnblogs.com/gatsby123/p/11150472.html#%E4%B8%BA%E4%BB%80%E4%B9%88%E9%9C%80%E8%A6%81%E5%AE%BD%E5%AD%97%E7%AC%A6%E7%B1%BB%E5%9E%8B\">为什么需要宽字符类型</a></li><li><a href=\"https://www.cnblogs.com/gatsby123/p/11150472.html#%E5%A4%9A%E5%AD%97%E8%8A%82%E5%AD%97%E7%AC%A6%E4%B8%B2%E5%92%8C%E5%AE%BD%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9B%B8%E4%BA%92%E8%BD%AC%E6%8D%A2\">多字节字符串和宽字符串相互转换</a></li></ul></li></ul></div></div><p>最近使用到了wchar_t类型，所以准备详细探究下，没想到水还挺深，网上的资料大多都是复制粘贴，只有个结论，也没个验证过程。本文记录探究的过程及结论，如有不对请指正。</p><h2 id=\"unicodeucs\">Unicode、UCS</h2><p>UCS（Universal Character Set）本质上就是一个字符集。<br>Unicode的开发结合了国际标准化组织所制定的&nbsp;ISO/IEC 10646，即通用字符集（<br>Universal Character Set, UCS）。Unicode 与 ISO/IEC 10646 在编码的运作原理相同，但&nbsp;The Unicode Standard&nbsp;包含了更详尽的实现信息、涵盖了更细节的主题，诸如比特编码（bitwise encoding）、校对以及呈现等。摘自（<a href=\"https://zh.wikipedia.org/zh-cn/Unicode#%E6%A8%99%E6%BA%96\">Unicode</a>)<br>所以也可以简单的理解为，Unicode和UCS等价，都是字符集。</p><p>UCS编码的长度是31位，可用4个字节表示，可以表示2的31次方个字符。如果两个字符的高位相同，只有低16位不同，则它们属于同一平面，所以一个平面由2的16次方个字符组成。目前大部分字符都位于第一个平面称为BMP。BMP的编码通常以U+xxxx这种形式表示，其中x是16进制数。<br>比如中文“你”对应的UCS编码为U+4f60，“好”对应的UCS编码为U+597d。更多中文编码可以在<a href=\"http://www.chi2ko.com/tool/CJK.htm\">Unicode编码表</a>中查询。</p><p>有了UCS编码，任何一个字符在计算机中都最多可以用四个字节来表示，称为码点。</p><h2 id=\"utf8\">UTF8</h2><p>现在有了UCS字符集，那么一个字符在计算机中真的要按四个字节（UTF-32）来存储吗？<br>答案是否定的，一方面每个字符都按四字节来存储非常浪费空间，因为大部分字符都在BMP，只有后16位有效，前16位都是0。另一方面这与c语言不兼容，在c语言中0字节表示字符串的结尾，库函数strlen等函数依赖这一点，如果按UTF-32存储，其中有很多0字节并不表示字符串结尾。</p><p>Ken Thompson发明了UTF-8编码，可以很好的解决以上问题。Unicode 和 UTF-8 之间的转换关系表如下：</p><table><thead><tr><th>码点起值</th><th>码点终值</th><th>字节序列</th><th>Byte1</th><th>Byte2</th><th>Byte3</th><th>Byte4</th><th>Byte5</th><th>Byte6</th></tr></thead><tbody><tr><td>U+0000</td><td>U+007F</td><td>1</td><td>0xxxxxxx</td><td></td><td></td><td></td><td></td><td></td></tr><tr><td>U+0080</td><td>U+07FF</td><td>2</td><td>110xxxxx</td><td>10xxxxxx</td><td></td><td></td><td></td><td></td></tr><tr><td>U+0800</td><td>U+FFFF</td><td>3</td><td>1110xxxx</td><td>10xxxxxx</td><td>10xxxxxx</td><td></td><td></td><td></td></tr><tr><td>U+10000</td><td>U+1FFFFF</td><td>4</td><td>11110xxx</td><td>10xxxxxx</td><td>10xxxxxx</td><td>10xxxxxx</td><td></td><td></td></tr><tr><td>U+200000</td><td>U+3FFFFFF</td><td>5</td><td>111110xx</td><td>10xxxxxx</td><td>10xxxxxx</td><td>10xxxxxx</td><td>10xxxxxx</td><td></td></tr><tr><td>U+4000000</td><td>U+7FFFFFFF</td><td>6</td><td>1111110x</td><td>10xxxxxx</td><td>10xxxxxx</td><td>10xxxxxx</td><td>10xxxxxx</td><td>10xxxxxx</td></tr></tbody></table><p>第一个字节要么最高位是0（ASCII码），要么最高位都是1，最高位之后的1的个数决定了后面的有多少个字节也属于当前字符编码，例如111110xx，最高位之后还有4个1，表示后面的4个字节属于当前编码。后面的每个字节的最高位都是10，可以和第一个字节区分开来。后面字节的x表示的就是UCS编码。所以UTF-8就像一列火车，第一个字节是车头，包含了后面的哪几个字节也属于当前这列火车的信息，后面的字节是车厢，其中承载着UCS编码。</p><p>以中文字符“你”为例，对应的Unicode为\"U+4f60\"，二进制表示为0100 1111 0110 0000。按照表中的规则编码成UTF-8就是11100100 10111101 10100000（0xe4 0xbd 0xa0）。</p><h3 id=\"结论\">结论：</h3><p>Unicode本质是字符集，在这个集合中的任意一个字符都可以用一个四字节来表示。</p><p>UTF-8是编码规则，可以通过这个规则将Unicode字符集中任一字符对应的字节转换为另一个字节序列。UTF-8只是编码规则中的一种，其它的编码规则还有UTF-16，UTF-32等。</p><h2 id=\"宽字符类型wchar_t\">宽字符类型wchar_t</h2><p>在介绍宽字符前先了解下locale。因为多字节字符串和宽字符串的转换和locale相关。</p><h3 id=\"locale\">locale</h3><h4 id=\"什么是locale\">什么是locale</h4><p>区域设置（locale），也称作“本地化策略集”、“本地环境”，是表达程序用户地区方面的软件设定。在linux执行<code>locale</code>可以查看当前locale设置：</p><pre><code>ubuntu@VM-0-16-ubuntu:~$ locale\r\nLANG=zh_CN.UTF-8\r\nLANGUAGE=\r\nLC_CTYPE=\"zh_CN.UTF-8\"\r\nLC_NUMERIC=\"zh_CN.UTF-8\"\r\nLC_TIME=\"zh_CN.UTF-8\"\r\nLC_COLLATE=\"zh_CN.UTF-8\"\r\nLC_MONETARY=\"zh_CN.UTF-8\"\r\nLC_MESSAGES=\"zh_CN.UTF-8\"\r\nLC_PAPER=\"zh_CN.UTF-8\"\r\nLC_NAME=\"zh_CN.UTF-8\"\r\nLC_ADDRESS=\"zh_CN.UTF-8\"\r\nLC_TELEPHONE=\"zh_CN.UTF-8\"\r\nLC_MEASUREMENT=\"zh_CN.UTF-8\"\r\nLC_IDENTIFICATION=\"zh_CN.UTF-8\"\r\nLC_ALL=</code></pre><p>可以将locale理解为一系列环境变量。locale环境变量值的格式为<code>language_area.charset</code>。languag表示语言，例如英语或中文；area表示使用该语言的地区，例如美国或者中国大陆；charset表示字符集编码，例如UTF-8或者GBK。<br>这些环境变量会对日期格式，数字格式，货币格式，字符处理等多个方面产生影响。</p><p>参考资料：</p><ol><li><a href=\"https://zh.wikipedia.org/zh-cn/%E5%8C%BA%E5%9F%9F%E8%AE%BE%E7%BD%AE#Ubuntu%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F\">locale wiki</a></li><li><a href=\"http://pubs.opengroup.org/onlinepubs/7908799/xbd/envvar.html\">Environment Variables</a></li></ol><h4 id=\"如何设置系统默认的locale\">如何设置系统默认的locale</h4><p>修改配置文件/etc/default/locale，比如要将locale设为zh_CN.UTF-8，添加如下语句<code>LANG=zh_CN.UTF-8</code></p><h4 id=\"locale环境变量有何作用\">locale环境变量有何作用</h4><p>以LC_TIME为例，该变量会影响strftime()等函数。<code>size_t strftime(char *str, size_t maxsize, const char *format, const struct tm *timeptr)</code><br>strftime根据format中定义的格式化规则，格式化结构timeptr表示的时间，并把它存储在str中。</p><pre><code>#include <locale.h>\r\n#include <stdio.h>\r\n#include <time.h>\r\n\r\nint main () {\r\n    time_t currtime;\r\n    struct tm *timer;\r\n    char buffer[80];\r\n\r\n    time( &amp;currtime );\r\n    timer = localtime( &amp;currtime );\r\n\r\n    printf(\"Locale is: %s\\n\", setlocale(LC_TIME, \"en_US.iso88591\"));\r\n    strftime(buffer,80,\"%c\", timer );\r\n    printf(\"Date is: %s\\n\", buffer);\r\n\r\n    printf(\"Locale is: %s\\n\", setlocale(LC_TIME, \"zh_CN.UTF-8\"));\r\n    strftime(buffer,80,\"%c\", timer );\r\n    printf(\"Date is: %s\\n\", buffer);\r\n\r\n    printf(\"Locale is: %s\\n\", setlocale(LC_TIME, \"\"));\r\n    strftime(buffer,80,\"%c\", timer );\r\n    printf(\"Date is: %s\\n\", buffer);\r\n    return(0);\r\n}</time.h></stdio.h></locale.h></code></pre><p>编译后运行结果如下：</p><pre><code>Locale is: en_US.iso88591\r\nDate is: Sun 07 Jul 2019 04:08:39 PM CST\r\nLocale is: zh_CN.UTF-8\r\nDate is: 2019年07月07日 星期日 16时08分39秒\r\nLocale is: zh_CN.UTF-8\r\nDate is: 2019年07月07日 星期日 16时08分39秒</code></pre><p>可以看到对LC_TIME设置不同的值后，调用strftime()会产生不同的结果。<br><code>char* setlocale (int category, const char* locale);</code>可以用来对当前程序进行地域设置。<br>category：用于指定设置影响的范围，<code>LC_CTYPE</code>影响字符分类和字符转换，<code>LC_TIME</code>影响日期和时间的格式，<code>LC_ALL</code>影响所有内容。<br>locale：用于指定变量的值，上例中分别使用了\"en_US.iso88591\"，\"zh_CN.UTF-8\"和空字符串\"\"，\"\"表示使用当前操作系统默认的区域设置。</p><p>参考资料：<br><a href=\"http://c.biancheng.net/ref/setlocale.html\">setlocale()</a></p><h3 id=\"为什么需要宽字符类型\">为什么需要宽字符类型</h3><p>“你好”对应的Unicode分别为\"U+4f60\"和\"U+597d”，对应的UTF-8编码分别为“0xe4 0xbd 0xa0”和“0xe5 0xa5 0xbd”</p><h4 id=\"多字节字符串在编译后的可执行文件以utf-8编码保存\">多字节字符串在编译后的可执行文件以UTF-8编码保存</h4><pre><code>#include <stdio.h>\r\n#include <string.h>\r\n\r\nint main(void) {\r\n    char s[] = \"你好\";\r\n    size_t len = strlen(s);\r\n    printf(\"len = %d\\n\", (int)len);\r\n    printf(\"%s\\n\", s);\r\n    return 0;\r\n}</string.h></stdio.h></code></pre><p>编译后执行，输出如下：</p><pre><code>len = 6\r\n你好</code></pre><p>od编译后的可执行文件，可以发现\"你好\"以UFT-8编码保存，也就是“0xe4 0xbd 0xa0”和“0xe5 0xa5 0xbd”6个字节。<br>strlen()函数只管结尾的0字节而不管字符串里存的是什么，所以len是6，也就是“你好”的UFT-8编码的字节数。<br><code>printf(\"%s\\n\", s);</code>相当于将“0xe4 0xbd 0xa0”和“0xe5 0xa5 0xbd”6个字节write到当前终端的设备文件，如果当前终端的驱动程序能识别UTF-8编码就能打印汉字，如果当前字符终端的驱动程序不能识别UTF-8就打印不出汉字。</p><h4 id=\"宽字符串在编译后可执行文件中以unicode保存\">宽字符串在编译后可执行文件中以Unicode保存</h4><pre><code>#include <wchar.h>\r\n#include <stdio.h>\r\n#include <locale.h>\r\n\r\nint main(void) {\r\n    setlocale(LC_ALL, \"zh_CN.UTF-8\");   //设置locale\r\n    wchar_t s[] = L\"你好\";\r\n    size_t len = wcslen(s);\r\n    printf(\"len = %d\\n\", (int)len);\r\n    printf(\"%ls\\n\", s);\r\n    return 0;\r\n}</locale.h></stdio.h></wchar.h></code></pre><p>编译后执行，输出如下：</p><pre><code>len = 2\r\n你好</code></pre><p>对编译后的可执行文件执行od命令，可以找到如下这些字节：</p><pre><code>193 0003020 001&nbsp;&nbsp;\\0 002&nbsp;&nbsp;\\0&nbsp;&nbsp;&nbsp;`&nbsp;&nbsp;&nbsp;O&nbsp;&nbsp;\\0&nbsp;&nbsp;\\0&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;&nbsp;Y&nbsp;&nbsp;\\0&nbsp;&nbsp;\\0&nbsp;&nbsp;\\n&nbsp;&nbsp;\\0&nbsp;&nbsp;\\0&nbsp;&nbsp;\\0\r\n194&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;00020001&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;00004f60&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0000597d&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0000000a</code></pre><p>00004f60正是“你”对应的Unicode，0000597d是“好”对应的Unicode。所以对于宽字符串是按Unicode保存在可执行文件中的。<br>wchar_t是宽字符类型。在字符常量或者字符串前加L就表示宽字符常量或者宽字符串。所以len是2。<br>wcslen()和strlen()不同，不是见到0字节就结束而是要遇到UCS编码为0的字符才结束。<br>目前宽字符在内存中以Unicode进行保存，但是要write到终端仍然需要以多字节编码输出，这样终端驱动程序才能识别，所以printf在内部把宽字符串转换成多字节字符串，然后write出去。这个转换过程受locale影响，<code>setlocale(LC_ALL, \"zh_CN.UTF-8\");</code>设置当前进程的LC_ALL为zh_CN.UTF-8，所以printf将Unicode转成多字节的UTF-8编码，然后write到终端设备。如果将<code>setlocale(LC_ALL, \"zh_CN.UTF-8\");</code>改为<code>setlocale(LC_ALL, en_US.iso88591):</code>打印结果中将不会输出\"你好\"。</p><p>一般来说程序在内存计算时通常以宽字符编码，存盘或者网络发送则用多字节编码。</p><h3 id=\"多字节字符串和宽字符串相互转换\">多字节字符串和宽字符串相互转换</h3><p>c语言中提供了多字节字符串和宽字符串相互转换的函数。</p><pre><code>#include <stdlib.h>\r\nsize_t mbstowcs(wchar_t *dest, const char *src, size_t n);\r\nsize_t wcstombs(char *dest, const wchar_t *src, size_t n);</stdlib.h></code></pre><p>mbstowcs()将多字节字符串转换为宽字符串。<br>wcstombs()将宽字符串转换为多字节字符串。<br>考虑下面的例子：</p><pre><code>#include <locale.h>\r\n#include <stdio.h>\r\n#include <time.h>\r\n#include <stdlib.h>\r\n#include <wchar.h>\r\n#include <string.h>\r\n\r\nwchar_t* str2wstr(const char const* s) {\r\n    const size_t buffer_size = strlen(s) + 1;\r\n    wchar_t* dst_wstr = (wchar_t *)malloc(buffer_size * sizeof (wchar_t));\r\n    wmemset(dst_wstr, 0, buffer_size);\r\n    mbstowcs(dst_wstr, s, buffer_size); \r\n    return dst_wstr;\r\n}\r\n\r\nvoid printBytes(const unsigned char const* s, int len) {\r\n    for (int i = 0; i &lt; len; i++) {\r\n        printf(\"0x%02x \", *(s + i));\r\n    }\r\n    printf(\"\\n\");\r\n}\r\n\r\nint main () {\r\n    char s[10] = \"你好\";          //内存中对应0xe4 0xbd 0xa0 0xe5 0xa5 0xbd 0x00 \r\n    wchar_t ws[10] = L\"你好\";  //内存中对应0x60 0x4f 0x00 0x00 0x7d 0x59 0x00 0x00 0x00 0x00 0x00 0x00 \r\n\r\n    printf(\"Locale is: %s\\n\", setlocale(LC_ALL, \"zh_CN.UTF-8\")); //Locale is: zh_CN.UTF-8\r\n    printBytes(s, 7);       //0xe4 0xbd 0xa0 0xe5 0xa5 0xbd 0x00 \r\n    printBytes((char *)ws, 12);  //0x60 0x4f 0x00 0x00 0x7d 0x59 0x00 0x00 0x00 0x00 0x00 0x00 \r\n\r\n    printBytes((char *)str2wstr(s), 12); //0x60 0x4f 0x00 0x00 0x7d 0x59 0x00 0x00 0x00 0x00 0x00 0x00 \r\n\r\n    return(0);\r\n}</string.h></wchar.h></stdlib.h></time.h></stdio.h></locale.h></code></pre><p>编译后，执行结果如下：</p><pre><code>Locale is: zh_CN.UTF-8\r\n0xe4 0xbd 0xa0 0xe5 0xa5 0xbd 0x00 \r\n0x60 0x4f 0x00 0x00 0x7d 0x59 0x00 0x00 0x00 0x00 0x00 0x00 \r\n0x60 0x4f 0x00 0x00 0x7d 0x59 0x00 0x00 0x00 0x00 0x00 0x00 </code></pre><p>第二行输出也印证了我们之前说的多字节字符串在内存中以UTF-8存储，\"0xe4 0xbd 0xa0 0xe5 0xa5 0xbd\"正是\"你好\"的UTF-8编码。<br>第三行输出印证了之前说的宽字符串在内存中以Unicode存储，\"0x60 0x4f 0x00 0x00 0x7d 0x59 0x00 0x00\"正好是宽字符串L\"你好\"对应的Unicode。<br><code>setlocale(LC_ALL, \"zh_CN.UTF-8\")</code>设置locale，程序将以UTF-8解码宽字符串。调用mbstowcs()后，可以看到“你好”的UTF-8编码 \"0xe4 0xbd 0xa0 0xe5 0xa5 0xbd 0x00\"确实被转换成了“你好”对应的Unicode \"0x60 0x4f 0x00 0x00 0x7d 0x59 0x00 0x00 0x00 0x00 0x00 0x00\"。<br>如果将<code>setlocale(LC_ALL, \"zh_CN.UTF-8\")</code>换成<code>setlocale(LC_ALL, \"en_US.iso88591 \");</code>那么最后一行的输出也就会不一样。</p></span><p><br></p>', '0', '2019-06-01 06:37:24', '2019-07-08 06:40:09', '0', '0', '\\attachment\\u=2962033657,4245604671&fm=27&gp=0.jpg');
INSERT INTO `article` VALUES ('36', '1', '2', 'MyBatis从入门到精通(六)：MyBatis动态Sql之if标签的用法', '<div id=\"cnblogs_post_body\"><p>最近在读刘增辉老师所著的《MyBatis从入门到精通》一书，很有收获，于是将自己学习的过程以博客形式输出，如有错误，欢迎指正，如帮助到你，不胜荣幸！</p><p>本篇博客主要讲解如何使用if标签生成动态的Sql，主要包含以下3个场景：</p><ol><li>根据查询条件实现动态查询</li><li>根据参数值实现动态更新某些列</li><li>根据参数值实现动态插入某些列</li></ol><h2 id=\"使用if标签实现动态查询\">1. 使用if标签实现动态查询</h2><p>假设有这样1个需求：根据用户的输入条件来查询用户列表，如果输入了用户名，就根据用户名模糊查询，如果输入了邮箱，就根据邮箱精确查询，如果同时输入了用户名和邮箱，就用这两个条件去匹配用户。</p><p>首先，我们在接口SysUserMapper中添加如下方法：</p><pre><code>/**\r\n * 根据动态条件查询用户信息\r\n *\r\n * @param sysUser\r\n * @return\r\n */\r\nList&lt;SysUser&gt; selectByUser(SysUser sysUser);</code></pre><p>然后在对应的SysUserMapper.xml中添加如下代码：</p><pre><code>&lt;select id=\"selectByUser\" resultType=\"com.zwwhnly.mybatisaction.model.SysUser\"&gt;\r\n    SELECT  id,\r\n            user_name,\r\n            user_password,\r\n            user_email,\r\n            create_time\r\n    FROM sys_user\r\n    WHERE 1 = 1\r\n    &lt;if test=\"userName != null and userName != \'\'\"&gt;\r\n        AND user_name LIKE CONCAT(\'%\',#{userName},\'%\')\r\n    &lt;/if&gt;\r\n    &lt;if test=\"userEmail != null and userEmail != \'\'\"&gt;\r\n        AND user_email = #{userEmail}\r\n    &lt;/if&gt;\r\n&lt;/select&gt;</code></pre><p>代码简单讲解：</p><p>1)if标签的test属性必填，该属性值是一个符合OGNL要求的判断表达式，一般只用true或false作为结果。</p><p>2)判断条件property != null 或 property == null，适用于任何类型的字段，用于判断属性值是否为空。</p><p>3)判断条件property != \'\' 或 property == \'\'，仅适用于String类型的字段，用于判断是否为空字符串。</p><p>4)当有多个判断条件时，使用and或or进行连接，嵌套的判断可以使用小括号分组，and相当于Java中的与(&amp;&amp;)，or相关于Java中的或(||)。</p><p>所以上面代码的意思就是先判断字段是否为null，然后再判断字段是否为空字符串。</p><p>最后，在SysUserMapperTest测试类中添加如下测试方法：</p><pre><code>@Test\r\npublic void testSelectByUser() {\r\n    SqlSession sqlSession = getSqlSession();\r\n\r\n    try {\r\n        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);\r\n\r\n        // 只按用户名查询\r\n        SysUser query = new SysUser();\r\n        query.setUserName(\"ad\");\r\n        List&lt;SysUser&gt; sysUserList = sysUserMapper.selectByUser(query);\r\n        Assert.assertTrue(sysUserList.size() &gt; 0);\r\n\r\n        // 只按邮箱查询\r\n        query = new SysUser();\r\n        query.setUserEmail(\"test@mybatis.tk\");\r\n        sysUserList = sysUserMapper.selectByUser(query);\r\n        Assert.assertTrue(sysUserList.size() &gt; 0);\r\n\r\n        // 同时按用户民和邮箱查询\r\n        query = new SysUser();\r\n        query.setUserName(\"ad\");\r\n        query.setUserEmail(\"test@mybatis.tk\");\r\n        sysUserList = sysUserMapper.selectByUser(query);\r\n        // 由于没有同时符合这两个条件的用户，因此查询结果数为0\r\n        Assert.assertTrue(sysUserList.size() == 0);\r\n    } finally {\r\n        sqlSession.close();\r\n    }\r\n}</code></pre><p>运行测试代码，测试通过，输出日志如下：</p><blockquote><p>DEBUG [main] - ==&gt; Preparing: SELECT id, user_name, user_password, user_email, create_time FROM sys_user WHERE 1 = 1 AND user_name LIKE CONCAT(\'%\',?,\'%\')</p><p>DEBUG [main] - ==&gt; Parameters: ad(String)</p><p>TRACE [main] - &lt;== Columns: id, user_name, user_password, user_email, create_time</p><p>TRACE [main] - &lt;== Row: 1, admin, 123456, admin@mybatis.tk, 2019-06-27 18:21:07.0</p><p>DEBUG [main] - &lt;== Total: 1</p><p>DEBUG [main] - ==&gt; Preparing: SELECT id, user_name, user_password, user_email, create_time FROM sys_user WHERE 1 = 1 AND user_email = ?</p><p>DEBUG [main] - ==&gt; Parameters: test@mybatis.tk(String)</p><p>TRACE [main] - &lt;== Columns: id, user_name, user_password, user_email, create_time</p><p>TRACE [main] - &lt;== Row: 1001, test, 123456, test@mybatis.tk, 2019-06-27 18:21:07.0</p><p>DEBUG [main] - &lt;== Total: 1</p><p>DEBUG [main] - ==&gt; Preparing: SELECT id, user_name, user_password, user_email, create_time FROM sys_user WHERE 1 = 1 AND user_name LIKE CONCAT(\'%\',?,\'%\') AND user_email = ?</p><p>DEBUG [main] - ==&gt; Parameters: ad(String), test@mybatis.tk(String)</p><p>DEBUG [main] - &lt;== Total: 0</p></blockquote><h2 id=\"使用if标签实现动态更新\">2. 使用if标签实现动态更新</h2><p>假设有这样1个需求：更新用户信息的时候不能将原来有值但没有发生变化的字段更新为空或null，即只更新有值的字段。</p><p>首先，我们在接口SysUserMapper中添加如下方法：</p><pre><code>/**\r\n * 根据主键选择性更新用户信息\r\n *\r\n * @param sysUser\r\n * @return\r\n */\r\nint updateByIdSelective(SysUser sysUser);</code></pre><p>然后在对应的SysUserMapper.xml中添加如下代码：</p><pre><code>&lt;update id=\"updateByIdSelective\"&gt;\r\n    UPDATE sys_user\r\n    SET\r\n    &lt;if test=\"userName != null and userName != \'\'\"&gt;\r\n        user_name = #{userName},\r\n    &lt;/if&gt;\r\n    &lt;if test=\"userPassword != null and userPassword != \'\'\"&gt;\r\n        user_password = #{userPassword},\r\n    &lt;/if&gt;\r\n    &lt;if test=\"userEmail != null and userEmail != \'\'\"&gt;\r\n        user_email = #{userEmail},\r\n    &lt;/if&gt;\r\n    &lt;if test=\"userInfo != null and userInfo != \'\'\"&gt;\r\n        user_info = #{userInfo},\r\n    &lt;/if&gt;\r\n    &lt;if test=\"headImg != null\"&gt;\r\n        head_img = #{headImg,jdbcType=BLOB},\r\n    &lt;/if&gt;\r\n    &lt;if test=\"createTime != null\"&gt;\r\n        create_time = #{createTime,jdbcType=TIMESTAMP},\r\n    &lt;/if&gt;\r\n    id = #{id}\r\n    WHERE id = #{id}\r\n&lt;/update&gt;</code></pre><p>最后，在SysUserMapperTest测试类中添加如下测试方法：</p><pre><code>@Test\r\npublic void testUpdateByIdSelective() {\r\n    SqlSession sqlSession = getSqlSession();\r\n\r\n    try {\r\n        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);\r\n\r\n        SysUser sysUser = new SysUser();\r\n        // 更新id=1的用户\r\n        sysUser.setId(1L);\r\n        // 修改邮箱\r\n        sysUser.setUserEmail(\"test@mybatis.tk\");\r\n\r\n        int result = sysUserMapper.updateByIdSelective(sysUser);\r\n        Assert.assertEquals(1, result);\r\n\r\n        // 查询id=1的用户\r\n        sysUser = sysUserMapper.selectById(1L);\r\n        // 修改后的名字保持不变，但是邮箱变成了新的\r\n        Assert.assertEquals(\"admin\", sysUser.getUserName());\r\n        Assert.assertEquals(\"test@mybatis.tk\", sysUser.getUserEmail());\r\n    } finally {\r\n        sqlSession.close();\r\n    }\r\n}</code></pre><p>运行测试代码，测试通过，输出日志如下：</p><blockquote><p>DEBUG [main] - ==&gt; Preparing: UPDATE sys_user SET user_email = ?, id = ? WHERE id = ?</p><p>DEBUG [main] - ==&gt; Parameters: test@mybatis.tk(String), 1(Long), 1(Long)</p><p>DEBUG [main] - &lt;== Updates: 1</p><p>DEBUG [main] - ==&gt; Preparing: SELECT id, user_name, user_password, user_email, create_time FROM sys_user WHERE id = ?</p><p>DEBUG [main] - ==&gt; Parameters: 1(Long)</p><p>TRACE [main] - &lt;== Columns: id, user_name, user_password, user_email, create_time</p><p>TRACE [main] - &lt;== Row: 1, admin, 123456, test@mybatis.tk, 2019-06-27 18:21:07.0</p><p>DEBUG [main] - &lt;== Total: 1</p></blockquote><h2 id=\"使用if标签实现动态插入\">3. 使用if标签实现动态插入</h2><p>假设有这样1个需求：往数据库表中插入数据的时候，如果某一列的参数值不为空，就使用传入的值，如果传入的参数值为空，就使用数据库中的默认值(通常是空)，而不使用传入的空值。</p><p>为了更好的理解该示例，我们先给sys_user表的user_email字段设置默认值：test@mybatis.tk，Sql语句如下：</p><pre><code>ALTER TABLE sys_user\r\nMODIFY COLUMN user_email VARCHAR(50) NULL DEFAULT  \'test@mybatis.tk\'\r\nCOMMENT \'邮箱\'\r\nAFTER user_password;</code></pre><p>首先，我们在接口SysUserMapper中添加如下方法：</p><pre><code>/**\r\n * 根据传入的参数值动态插入列\r\n *\r\n * @param sysUser\r\n * @return\r\n */\r\nint insertSelective(SysUser sysUser);</code></pre><p>然后在对应的SysUserMapper.xml中添加如下代码：</p><pre><code>&lt;insert id=\"insertSelective\" useGeneratedKeys=\"true\" keyProperty=\"id\"&gt;\r\n    INSERT INTO sys_user(user_name, user_password,\r\n    &lt;if test=\"userEmail != null and userEmail != \'\'\"&gt;\r\n        user_email,\r\n    &lt;/if&gt;\r\n    user_info, head_img, create_time)\r\n    VALUES (#{userName},#{userPassword},\r\n    &lt;if test=\"userEmail != null and userEmail != \'\'\"&gt;\r\n        #{userEmail},\r\n    &lt;/if&gt;\r\n    #{userInfo},#{headImg,jdbcType=BLOB},#{createTime,jdbcType=TIMESTAMP})\r\n&lt;/insert&gt;</code></pre><p>最后，在SysUserMapperTest测试类中添加如下测试方法：</p><pre><code>@Test\r\npublic void testInsertSelective() {\r\n    SqlSession sqlSession = getSqlSession();\r\n\r\n    try {\r\n        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);\r\n\r\n        SysUser sysUser = new SysUser();\r\n        sysUser.setUserName(\"test-selective\");\r\n        sysUser.setUserPassword(\"123456\");\r\n        sysUser.setUserInfo(\"test info\");\r\n        sysUser.setCreateTime(new Date());\r\n\r\n        sysUserMapper.insertSelective(sysUser);\r\n\r\n        // 获取刚刚插入的数据\r\n        sysUser = sysUserMapper.selectById(sysUser.getId());\r\n        // 因为没有指定userEmail,所以用的是数据库的默认值\r\n        Assert.assertEquals(\"test@mybatis.tk\", sysUser.getUserEmail());\r\n    } finally {\r\n        sqlSession.close();\r\n    }\r\n}</code></pre><p>运行测试代码，测试通过，输出日志如下：</p><blockquote><p>DEBUG [main] - ==&gt; Preparing: INSERT INTO sys_user(user_name, user_password, user_info, head_img, create_time) VALUES (?,?, ?,?,?)</p><p>DEBUG [main] - ==&gt; Parameters: test-selective(String), 123456(String), test info(String), null, 2019-07-08 11:40:36.927(Timestamp)</p><p>DEBUG [main] - &lt;== Updates: 1</p><p>DEBUG [main] - ==&gt; Preparing: SELECT id, user_name, user_password, user_email, create_time FROM sys_user WHERE id = ?</p><p>DEBUG [main] - ==&gt; Parameters: 1021(Long)</p><p>TRACE [main] - &lt;== Columns: id, user_name, user_password, user_email, create_time</p><p>TRACE [main] - &lt;== Row: 1021, test-selective, 123456, test@mybatis.tk, 2019-07-08 11:40:37.0</p><p>DEBUG [main] - &lt;== Total: 1</p></blockquote><h2 id=\"源码\">4. 源码</h2><p>源码地址：<a href=\"https://github.com/zwwhnly/mybatis-action.git\">https://github.com/zwwhnly/mybatis-action.git</a>，欢迎下载。</p><h2 id=\"参考\">5. 参考</h2><p>刘增辉《MyBatis从入门到精通》</p></div><div></div><div id=\"blog_post_info_block\"><div id=\"BlogPostCategory\">分类:&nbsp;<a href=\"https://www.cnblogs.com/zwwhnly/category/1492402.html\" target=\"_blank\">MyBatis</a></div></div>', '0', '2019-07-08 06:41:21', '2019-07-08 06:41:21', '0', '0', '\\attachment\\u=3300305952,1328708913&fm=26&gp=0 - 副本.jpg');
INSERT INTO `article` VALUES ('37', '1', '1', 'js深入（四）万脸懵圈的this指向', '<blockquote><p>作为一个js菜鸡的我而言，在之前讲到过那么多的js链式查找机制，比如说原型链，作用域链等等，想当然的把这个机制带入到了this指向上边，结果就是这个this指向指的我万脸懵逼（标题换字了，担心被河蟹）,在经过漫长的通（gou）俗（pi）易（bu）懂（tong）的 ECMAScript规范阅读之后，分享一下我所认知的this指向</p></blockquote><blockquote><p>简而言之，js中this的指向不是在函数定义的时候确定的，而是在调用的时候创建阶段确定的，也就是说this指向谁，完全取决于函数的调用方式</p></blockquote><h2 id=\"常见的几种调用方式\">常见的几种调用方式</h2><ul><li><p>直接调用， 比如说</p><pre><code>  function a() {\r\n  console.log(this);  \r\n  }\r\n\r\n  a();  </code></pre></li></ul><p>这个例子里边this指向的是全局对象，在客户端的全局对象是window对象，在node 中的全局对象是global对象</p><pre><code>    (function a() {\r\n        function b() {\r\n            console.log(this);  \r\n        }\r\n        b()\r\n    })()</code></pre><blockquote><p>直接调用指的是直接用函数名称后边加（）执行调用的函数，无论是否在全局作用域</p></blockquote><ul><li><p>间接调用</p><pre><code>  const obj ={\r\n      name:\'obj对象\',\r\n      a(){\r\n          console.log(this)\r\n      }\r\n  }\r\n  obj.a()</code></pre></li></ul><p>如图</p><p><img src=\"https://img2018.cnblogs.com/blog/1606021/201907/1606021-20190708111254329-1043567547.jpg\"></p><p>在图中我们可以看到我们在对象里边调用对象里边的方法的时候，this指向的是obj对象，</p><p>或者说外边有一个函数 然后给一个obj对象的属性赋值</p><pre><code>    const obj ={\r\n        name:\'obj对象\',\r\n        a(){\r\n            console.log(this)\r\n        }\r\n    }\r\n    obj.a()\r\n    obj.b=function(){\r\n        console.log(this,\'b\')\r\n    }\r\n    obj.b()</code></pre><p>打印的结果都是obj对象</p><ul><li>new调用</li></ul><p>当我们他用过new 创建一个新的对象的时候，new会调用这个构造函数来创建一个对象，那么这个对象里边的this是这个被new的函数调用的，那么自然 new调用的时候，this就是指向这个新对象的</p><pre><code>    function A(data) {\r\n        this.data = data;\r\n    }\r\n    class B{\r\n        constructor(data){\r\n              this.data = data\r\n        }\r\n    }\r\n    let a = new A(\"A\");\r\n    let b = new B(\"B\");\r\n    console.log(a.data);   \r\n    console.log(b.data);   </code></pre><p>如图</p><p><img src=\"https://img2018.cnblogs.com/blog/1606021/201907/1606021-20190708111306337-1307397958.jpg\"></p><p>这个new，在创建对象的时候做了什么，我们会在下一篇博客里边仔细说明</p><ul><li>箭头函数中的this</li></ul><p>箭头函数可以理解成是是一个语法糖，他没有自己的this绑定，箭头函数中使用的this是包含他的那个函数的this</p><p>比如说</p><pre><code>    const obj = {\r\n        a() {\r\n            return () =&gt; {\r\n                console.log(this);\r\n            };\r\n        }\r\n    }    </code></pre><p>上边这段代码被转译成es5 的时候如下</p><pre><code>const obj = {\r\n    a: function a() {\r\n        var _this = this;\r\n        return function () {\r\n            console.log(_this);\r\n        };\r\n    }\r\n};</code></pre><p>综合以上所有的代码，得出一个结论就是，在js中this的绑定正常来讲是指向调用这个方法的对象来确定的，当然还有一些不正常的方法，可以改变this的指向</p><blockquote><p>注意 ，下边介绍的几种方法，不能改变箭头函数的this指向，箭头函数本身是没有this绑定的，在介绍完不正常的情况后，再来说一说那些能够改变this指向的方法</p></blockquote><h2 id=\"ecmascript-5.1-规范的this指向\">ECMAScript 5.1 规范的this指向</h2><pre><code>      js中this的绑定正常来讲是指向调用这个方法的对象来确定的  \r\n      </code></pre><p>这句话在理论上是这么讲，在工作中正常的调用的话，这个理论是没有毛病的，在 ECMAScript 5.1 的规范里边规定，在js里边分为语言类型和规范类型</p><ul><li>语言类型</li></ul><p>ECMAScript 里边的语言类型规定的是我们可以直接操作的一些类型，比如string number，object等等这些</p><ul><li>规范类型</li></ul><p>规范类型ECMAScript 里边指的是一种抽象的规范，他们并不是让我们用来进行操作的，二是用来描述一些行为或者逻辑的，比如说typeof delete等等</p><p>ECMAScript 5.1 里边的this规定大概讲就是这样的，每个对象里边有一个Reference 规范类型，this会根据Reference这个规范类型进行赋值</p><p><a href=\"https://yanhaijing.com/es5/Ecma-262.pdf\">ECMAScript 5.1</a></p><p>规范奉上 Reference 这个东西大家简单的理解成是（）前边的那一块就好了，上边我们讲的那些正常的就是说左边是</p><ul><li>函数定义表达式</li><li>属性访问表达式</li><li>对象创建表达式</li><li>属性创建表达式</li></ul><p>这几种情况，在这几种情况的时候上边那句话是成立的</p><p>但是如果不是这上边的那几句话的时候，比如说括号里边是一个和函数相关计算或者一个运算符等等</p><p>这个时候this会指向undefined ，这个时候在非严格模式的情况下会被隐式转换成window对象</p><pre><code>    var value = 1;\r\n\r\n    var obj = {\r\n      value: 2,\r\n      a() {\r\n        return this.value;\r\n      }\r\n    }\r\n    \r\n    console.log(obj.a());\r\n    console.log((obj.a)());\r\n    console.log((obj.a = obj.a)());\r\n    console.log((false || obj.a)());\r\n    console.log((obj.a, obj.a)());\r\n    </code></pre><p>记得之前看到过这个一个例子，运行结果如图</p><p><img src=\"https://img2018.cnblogs.com/blog/1606021/201907/1606021-20190708111315019-1876882014.jpg\"></p><p>时间关系就说这些，下一篇博客会说new在运行时候过程和改变this指向的一些方法，<br>以上是我对this指向的一些认识，有不足的地方希望之处</p>', '0', '2019-07-08 07:42:11', '2019-07-08 07:42:11', '0', '0', '\\attachment\\girl1 - 副本 (2).jpg');
INSERT INTO `article` VALUES ('38', '1', '1', 'MySQL不支持INTERSECT和MINUS，及其替代方法', '<div>Doing INTERSECT and MINUS in MySQL</div><div><p>&nbsp;</p><p>Doing an INTERSECT</p><p>An INTERSECT is simply an inner join where we compare the tuples of one table with those of the other, and select those that appear in both while weeding out duplicates. So</p><p><code><u>SELECT member_id, name FROM a<br>INTERSECT<br>SELECT member_id, name FROM b</u></code></p><p>can simply be rewritten to</p><p><code>SELECT a.member_id, a.name<br>FROM a INNER JOIN b<br>USING (member_id, name)</code></p><p><strong>Performing a MINUS</strong><br>To transform the statement</p><p><code><u>SELECT member_id, name FROM a<br>MINUS<br>SELECT member_id, name FROM b</u></code></p><p>into something that MySQL can process, we can utilize subqueries (available from MySQL 4.1 onward). The easy-to-understand transformation is:</p><p><code>SELECT DISTINCT member_id, name<br>FROM a<br>WHERE (member_id, name) NOT IN<br>(SELECT member_id, name FROM table2);<br></code></p><p>Of course, to any long-time MySQL user, this is immediately obvious as the classical use-left-join-to-find-what-isn’t-in-the-other-table:</p><p><code>SELECT DISTINCT a.member_id, a.name<br>FROM a LEFT JOIN b USING (member_id, name)<br>WHERE b.member_id IS NULL</code></p></div>', '0', '2019-07-09 08:01:28', '2019-07-09 08:01:28', '0', '0', '\\attachment\\girl1 - 副本 (2) - 副本.jpg');
INSERT INTO `article` VALUES ('40', '1', '2', '666', '<p>6666</p>', '0', '2019-07-09 12:42:23', '2019-07-09 12:42:23', '0', '0', '\\attachment\\QQ截图20180422152014.png');
INSERT INTO `article` VALUES ('41', '1', '2', '8888', '<span><p>这是测试文章444</p></span><p><br></p>', '0', '2019-07-09 12:43:26', '2019-07-09 12:48:18', '0', '0', 'QQ截图20180424080812.png');

-- ----------------------------
-- Table structure for `article_category`
-- ----------------------------
DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category` (
  `article_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `user_category_id` int(11) DEFAULT NULL,
  `created_time` date NOT NULL,
  PRIMARY KEY (`article_category_id`),
  KEY `article_id` (`article_id`),
  KEY `user_category_id` (`user_category_id`),
  CONSTRAINT `article_category_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `article_category_ibfk_3` FOREIGN KEY (`user_category_id`) REFERENCES `user_category` (`user_category_id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_category
-- ----------------------------

-- ----------------------------
-- Table structure for `article_label`
-- ----------------------------
DROP TABLE IF EXISTS `article_label`;
CREATE TABLE `article_label` (
  `article_label_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `label_id` int(11) DEFAULT NULL,
  `created_time` date NOT NULL,
  PRIMARY KEY (`article_label_id`),
  KEY `label_id` (`label_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `article_label_ibfk_1` FOREIGN KEY (`label_id`) REFERENCES `label` (`label_id`),
  CONSTRAINT `article_label_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_label
-- ----------------------------

-- ----------------------------
-- Table structure for `article_sort`
-- ----------------------------
DROP TABLE IF EXISTS `article_sort`;
CREATE TABLE `article_sort` (
  `article_sort_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_sort_name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`article_sort_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_sort
-- ----------------------------
INSERT INTO `article_sort` VALUES ('1', '原创');
INSERT INTO `article_sort` VALUES ('2', '转载');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'SpringBoot');
INSERT INTO `category` VALUES ('2', 'Beego');

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL,
  `city_name` varchar(200) NOT NULL,
  `country_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '北京', '1');
INSERT INTO `city` VALUES ('2', '重庆', '1');
INSERT INTO `city` VALUES ('3', '东京', '2');
INSERT INTO `city` VALUES ('4', '新泰', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` text NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `comment_date` datetime DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `fk_user_id` (`user_id`),
  KEY `fk_article_id` (`article_id`),
  CONSTRAINT `fk_article_id` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('7', '215235', '2', '25', '2019-07-03 00:29:06');
INSERT INTO `comment` VALUES ('11', '242', '2', '26', '2019-07-03 01:33:29');
INSERT INTO `comment` VALUES ('12', '25326', '2', '25', '2019-07-03 01:33:37');
INSERT INTO `comment` VALUES ('13', '25326', '2', '25', '2019-07-03 01:33:41');
INSERT INTO `comment` VALUES ('14', '3353', '2', '26', '2019-07-03 01:33:52');
INSERT INTO `comment` VALUES ('18', '33', '1', '26', '2019-07-04 01:36:19');
INSERT INTO `comment` VALUES ('19', '2435', '3', '29', '2019-07-04 11:18:29');
INSERT INTO `comment` VALUES ('21', '2424', '2', '24', '2019-07-05 02:53:44');
INSERT INTO `comment` VALUES ('22', '66', '2', '24', '2019-07-05 04:39:22');
INSERT INTO `comment` VALUES ('23', '77', '2', '24', '2019-07-05 04:39:26');
INSERT INTO `comment` VALUES ('24', '77', '2', '24', '2019-07-05 04:41:07');
INSERT INTO `comment` VALUES ('25', '好', '2', '34', '2019-07-05 04:48:04');
INSERT INTO `comment` VALUES ('26', '嘿嘿', '2', '22', '2019-07-05 06:28:51');
INSERT INTO `comment` VALUES ('27', '66', '1', '38', '2019-07-09 08:01:47');
INSERT INTO `comment` VALUES ('29', '6', '2', '21', '2019-10-15 16:34:36');
INSERT INTO `comment` VALUES ('30', '6', '2', '37', '2019-10-16 01:50:30');

-- ----------------------------
-- Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `country_id` int(11) NOT NULL,
  `country_name` varchar(200) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', '中国');
INSERT INTO `country` VALUES ('2', '日本');

-- ----------------------------
-- Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `label_id` int(11) NOT NULL AUTO_INCREMENT,
  `label_name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`label_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', '微服务');
INSERT INTO `label` VALUES ('2', '智能合约');

-- ----------------------------
-- Table structure for `profession`
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `profession_id` int(11) NOT NULL AUTO_INCREMENT,
  `profession_name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`profession_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES ('1', '软件工程');
INSERT INTO `profession` VALUES ('2', '计算机科学与技术');

-- ----------------------------
-- Table structure for `rely`
-- ----------------------------
DROP TABLE IF EXISTS `rely`;
CREATE TABLE `rely` (
  `rely_id` int(11) NOT NULL AUTO_INCREMENT,
  `rely_content` text,
  `user_id` int(11) DEFAULT NULL,
  `comment_id` int(11) DEFAULT NULL,
  `rely_parent_id` int(11) DEFAULT NULL,
  `rely_date` datetime DEFAULT NULL,
  PRIMARY KEY (`rely_id`),
  KEY `user_id` (`user_id`),
  KEY `comment_id` (`comment_id`),
  KEY `rely_parent_id` (`rely_parent_id`),
  CONSTRAINT `rely_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `rely_ibfk_3` FOREIGN KEY (`rely_parent_id`) REFERENCES `rely` (`rely_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rely
-- ----------------------------
INSERT INTO `rely` VALUES ('2', '谷歌', '1', '2', null, '2019-07-02 18:02:26');
INSERT INTO `rely` VALUES ('3', '搜狗', '2', '2', null, '2019-07-02 18:03:14');
INSERT INTO `rely` VALUES ('4', '换个', '3', '1', null, '2019-07-02 18:03:36');
INSERT INTO `rely` VALUES ('5', '666', '3', null, '3', '2019-07-02 18:12:12');
INSERT INTO `rely` VALUES ('6', '哈哈哈', '2', null, '4', '2019-07-02 21:34:50');
INSERT INTO `rely` VALUES ('7', '烦烦烦方法', '2', '2', null, '2019-07-02 21:38:42');
INSERT INTO `rely` VALUES ('8', 'www', '3', null, '7', '2019-07-02 21:38:57');
INSERT INTO `rely` VALUES ('9', 'sgdh', '2', null, '8', '2019-07-02 21:39:26');
INSERT INTO `rely` VALUES ('10', '111', '2', '3', '11', '2019-07-02 21:39:42');
INSERT INTO `rely` VALUES ('11', '125235', '3', null, '9', '2019-07-02 21:40:15');
INSERT INTO `rely` VALUES ('12', '253', '2', null, '10', '2019-07-03 11:50:51');
INSERT INTO `rely` VALUES ('13', '2435', '3', null, '12', '2019-07-03 11:50:56');
INSERT INTO `rely` VALUES ('14', '13125', '2', null, '12', '2019-07-03 11:50:58');
INSERT INTO `rely` VALUES ('15', 'fsg', '1', null, '14', null);
INSERT INTO `rely` VALUES ('16', '666', '2', '7', null, '2019-07-05 02:58:14');
INSERT INTO `rely` VALUES ('17', '111', '2', '7', null, '2019-07-05 03:02:10');
INSERT INTO `rely` VALUES ('18', '嘿嘿', '2', '7', null, '2019-07-05 03:05:23');
INSERT INTO `rely` VALUES ('19', '666', '2', '7', null, '2019-07-05 03:06:48');
INSERT INTO `rely` VALUES ('20', '777', '2', '7', null, '2019-07-05 03:08:34');
INSERT INTO `rely` VALUES ('21', '嘻嘻', '2', '12', null, '2019-07-05 03:09:38');
INSERT INTO `rely` VALUES ('22', '777', '2', '13', null, '2019-07-05 03:11:29');
INSERT INTO `rely` VALUES ('23', '44', '2', '21', null, '2019-07-05 03:18:47');
INSERT INTO `rely` VALUES ('24', '555', '2', '21', null, '2019-07-05 03:18:51');
INSERT INTO `rely` VALUES ('25', '88888', '2', '2', null, '2019-07-05 04:44:35');
INSERT INTO `rely` VALUES ('26', '9999', '2', '2', null, '2019-07-05 04:44:41');
INSERT INTO `rely` VALUES ('27', '嗯', '2', '25', null, '2019-07-05 04:48:19');
INSERT INTO `rely` VALUES ('28', '666', '2', '12', null, '2019-07-05 04:49:19');
INSERT INTO `rely` VALUES ('29', '哈哈', '1', '26', null, '2019-07-05 06:29:18');
INSERT INTO `rely` VALUES ('30', '666', '1', '26', null, '2019-07-05 06:29:31');
INSERT INTO `rely` VALUES ('31', '666', '1', null, '4', '2019-07-05 06:49:55');
INSERT INTO `rely` VALUES ('32', '888', '3', null, '4', '2019-07-05 06:51:39');
INSERT INTO `rely` VALUES ('33', '999', '1', null, '4', '2019-07-05 06:52:42');
INSERT INTO `rely` VALUES ('34', '10', '1', null, '10', '2019-07-05 06:53:20');
INSERT INTO `rely` VALUES ('35', '666', '1', null, '4', '2019-07-05 07:01:01');
INSERT INTO `rely` VALUES ('36', '000000', '1', '1', null, '2019-07-05 07:08:20');
INSERT INTO `rely` VALUES ('37', '9999999999', '1', null, '36', '2019-07-05 07:08:32');
INSERT INTO `rely` VALUES ('38', '9999999', '1', '1', null, '2019-07-05 07:19:19');
INSERT INTO `rely` VALUES ('39', '55555', '1', null, '38', '2019-07-05 07:19:31');
INSERT INTO `rely` VALUES ('40', '99', '1', null, '10', '2019-07-05 07:20:26');
INSERT INTO `rely` VALUES ('41', '666', '1', null, '4', '2019-07-05 07:24:08');
INSERT INTO `rely` VALUES ('42', 'wwwww', '1', null, '2', '2019-07-05 07:26:25');
INSERT INTO `rely` VALUES ('43', '9999', '1', null, '25', '2019-07-05 07:26:36');
INSERT INTO `rely` VALUES ('44', '00000', '1', null, '4', '2019-07-05 10:38:46');
INSERT INTO `rely` VALUES ('45', '777', '1', '2', null, '2019-07-05 14:29:18');
INSERT INTO `rely` VALUES ('46', '嘿嘿', '1', null, '45', '2019-07-05 14:29:27');
INSERT INTO `rely` VALUES ('47', '哈哈', '1', null, '45', '2019-07-05 14:29:32');
INSERT INTO `rely` VALUES ('48', '35352535', '1', '1', null, '2019-07-08 07:44:18');
INSERT INTO `rely` VALUES ('49', '235352536', '1', null, '4', '2019-07-08 07:44:30');
INSERT INTO `rely` VALUES ('50', '77', '1', '27', null, '2019-07-09 08:01:50');
INSERT INTO `rely` VALUES ('51', '99', '1', null, '50', '2019-07-09 08:01:54');

-- ----------------------------
-- Table structure for `town`
-- ----------------------------
DROP TABLE IF EXISTS `town`;
CREATE TABLE `town` (
  `town_id` int(11) NOT NULL,
  `town_name` varchar(200) NOT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`town_id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `town_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of town
-- ----------------------------
INSERT INTO `town` VALUES ('1', '翟镇', '4');
INSERT INTO `town` VALUES ('2', '224', '2');
INSERT INTO `town` VALUES ('3', 'eg', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `profession_id` int(11) DEFAULT NULL,
  `town_id` int(11) DEFAULT NULL,
  `user_account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_truename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_phoneNum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_birthday` datetime DEFAULT NULL,
  `user_photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`user_account`),
  KEY `profession_id` (`profession_id`),
  KEY `town_id` (`town_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`profession_id`) REFERENCES `profession` (`profession_id`),
  CONSTRAINT `user_ibfk_4` FOREIGN KEY (`town_id`) REFERENCES `town` (`town_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, '2', 'xiaoming', 'adminczt', null, null, null, null, null, null, '22.jpg');
INSERT INTO `user` VALUES ('2', '2', '3', 'admin', '200934652qwe', null, null, null, null, null, null, 'girl1.jpg');
INSERT INTO `user` VALUES ('3', '1', '1', 'qr2532', '2353634', null, null, null, null, null, null, 'girl1.jpg');
INSERT INTO `user` VALUES ('4', '1', '2', '188725353', '25364646', null, null, null, null, null, null, 'girl1.jpg');

-- ----------------------------
-- Table structure for `user_article_collected`
-- ----------------------------
DROP TABLE IF EXISTS `user_article_collected`;
CREATE TABLE `user_article_collected` (
  `user_article_collected_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `created_time` date NOT NULL,
  PRIMARY KEY (`user_article_collected_id`),
  KEY `user_id` (`user_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `user_article_collected_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_article_collected_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_article_collected
-- ----------------------------

-- ----------------------------
-- Table structure for `user_article_likes`
-- ----------------------------
DROP TABLE IF EXISTS `user_article_likes`;
CREATE TABLE `user_article_likes` (
  `user_article_likes_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `created_time` date NOT NULL,
  PRIMARY KEY (`user_article_likes_id`),
  KEY `user_id` (`user_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `user_article_likes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_article_likes_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_article_likes
-- ----------------------------
INSERT INTO `user_article_likes` VALUES ('12', '2', '27', '2019-07-04');
INSERT INTO `user_article_likes` VALUES ('29', '2', '29', '2019-07-04');
INSERT INTO `user_article_likes` VALUES ('53', '1', '21', '2019-07-08');
INSERT INTO `user_article_likes` VALUES ('54', '1', '29', '2019-07-08');
INSERT INTO `user_article_likes` VALUES ('56', '1', '27', '2019-07-08');
INSERT INTO `user_article_likes` VALUES ('58', '1', '20', '2019-07-09');
INSERT INTO `user_article_likes` VALUES ('59', '2', '21', '2019-10-15');

-- ----------------------------
-- Table structure for `user_attention`
-- ----------------------------
DROP TABLE IF EXISTS `user_attention`;
CREATE TABLE `user_attention` (
  `user_attention_id` int(11) NOT NULL AUTO_INCREMENT,
  `focus_user_id` int(11) DEFAULT NULL,
  `focused_user_id` int(11) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  PRIMARY KEY (`user_attention_id`),
  KEY `focus_user_id` (`focus_user_id`),
  KEY `focused_user_id` (`focused_user_id`),
  CONSTRAINT `user_attention_ibfk_1` FOREIGN KEY (`focus_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_attention_ibfk_2` FOREIGN KEY (`focused_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_attention
-- ----------------------------
INSERT INTO `user_attention` VALUES ('14', '1', '2', '2019-07-06 13:24:14');
INSERT INTO `user_attention` VALUES ('20', '1', '1', '2019-07-12 12:04:22');

-- ----------------------------
-- Table structure for `user_category`
-- ----------------------------
DROP TABLE IF EXISTS `user_category`;
CREATE TABLE `user_category` (
  `user_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `created_time` date NOT NULL,
  PRIMARY KEY (`user_category_id`),
  KEY `user_id` (`user_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `user_category_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_category_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_category
-- ----------------------------

-- ----------------------------
-- View structure for `test_view1`
-- ----------------------------
DROP VIEW IF EXISTS `test_view1`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `test_view1` AS select `user`.`user_id` AS `user_id`,`user`.`user_account` AS `user_account` from `user` ;

-- ----------------------------
-- View structure for `user_article_view`
-- ----------------------------
DROP VIEW IF EXISTS `user_article_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_article_view` AS select `user`.`user_id` AS `user_id`,`article`.`article_id` AS `article_id`,`user`.`user_account` AS `user_account`,`article`.`article_title` AS `article_title`,`article`.`article_createdTime` AS `article_createdTime` from (`user` join `article`) where (`user`.`user_id` = `article`.`user_id`) ;
