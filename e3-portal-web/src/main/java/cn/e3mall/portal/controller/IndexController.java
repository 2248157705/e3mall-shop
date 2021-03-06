package cn.e3mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.pojo.TbContent;
import cn.e3mall.service.content.ContentService;
/**
 * 展示首页
 * @author LiuTaiwen
 *
 */
@Controller
public class IndexController {

	@Value("${CONTENT_LUNBO_ID}")
	private Long CONTENT_LUNBO_ID;
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String showIndex(Model model){
		//查询内容列表
		List<TbContent> list = contentService.getContentListByCid(CONTENT_LUNBO_ID);
		model.addAttribute("ad1List", list);
		return "index";
	}
}
