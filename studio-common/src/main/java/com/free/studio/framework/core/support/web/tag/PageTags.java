package com.free.studio.framework.core.support.web.tag;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.context.ApplicationContext;

import com.free.studio.framework.core.components.buitin.template.TemplateService;
import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.support.Pagination;

/**
 * @Title: PageTags.java
 * @Package com.free.studio.framework.core.support.web.tag
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午6:00:08
 * @version V1.0
 */
public class PageTags extends TagSupport {

	private static final long serialVersionUID = -2559691469859319420L;
	private static String FULL = "FULL";
	private static String NORMAL = "NORMAL";
	private static String SMALL = "SMALL";
	private Pagination pagination;
	private Integer pageNumber = Integer.valueOf(0);
	private String url;
	private String cssClass;
	private String type;
	private String pagepanelId;
	private String queryCondition;
	private String queryConditionPanelId;
	private PageButton first;
	private PageButton prev;
	private PageButton gotoPage;
	private PageButton next;
	private PageButton end;
	private PageButton refresh;
	private Integer pageTotal = Integer.valueOf(0);
	private Integer pageSize = Integer.valueOf(0);

	public int doStartTag() throws JspException {
		if (this.pagination == null) {
			return 0;
		}
		TemplateService templateService = (TemplateService) ContextManager.getRootContext()
				.getBean(TemplateService.class);
		JspWriter out = this.pageContext.getOut();
		buildButtons();
		Map context = buildContext();
		templateService.compile(out, "support/tags/pagebar.html", context);
		return 0;
	}

	private Map buildContext() {
		Map context = new HashMap();
		context.put("cssClass", this.cssClass);
		context.put("type", this.type);
		context.put("pagepanelId", this.pagepanelId);
		context.put("queryCondition", this.queryCondition);
		context.put("queryConditionPanel", this.queryConditionPanelId);
		context.put("pageNumber", this.pageNumber);
		context.put("pageSize", Integer.valueOf(this.pagination.getRowBounds().getLimit()));
		context.put("pageTotal", Integer.valueOf(this.pagination.getPageTotal()));
		context.put("firstButton", this.first);
		context.put("prevButton", this.prev);
		context.put("loadButton", this.gotoPage);
		context.put("nextButton", this.next);
		context.put("endButton", this.end);
		ApplicationContext ctx = ContextManager.getRootContext();

		context.put("pageDesc", "");
		context.put("refreshButton", this.refresh);
		return context;
	}

	public void buildButtons() {
		String firseDisabled = "";
		String endDisabled = "";
		if (this.pageNumber.intValue() == 1) {
			firseDisabled = PageButton.ISDISABLED;
		}
		if (this.pageNumber.intValue() == this.pagination.getPageTotal()) {
			endDisabled = PageButton.ISDISABLED;
		}
		this.first = new PageButton(this.url, PageButton.ICON_FIRST, firseDisabled);

		this.prev = new PageButton(this.url, PageButton.ICON_PREV, firseDisabled);

		this.gotoPage = new PageButton(this.url, PageButton.ICON_LOAD, "");

		this.next = new PageButton(this.url, PageButton.ICON_NEXT, endDisabled);

		this.end = new PageButton(this.url, PageButton.ICON_LAST, endDisabled);

		this.refresh = new PageButton(this.url, PageButton.ICON_REFRESH, "");
	}

	public void release() {
		super.release();
	}

	public int doEndTag() throws JspException {
		return 6;
	}

	public Pagination getPagination() {
		return this.pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Integer getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPagepanelId() {
		return this.pagepanelId;
	}

	public void setPagepanelId(String pagepanelId) {
		this.pagepanelId = pagepanelId;
	}

	public String getQueryCondition() {
		return this.queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getCssClass() {
		return this.cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getQueryConditionPanelId() {
		return this.queryConditionPanelId;
	}

	public void setQueryConditionPanelId(String queryConditionPanelId) {
		this.queryConditionPanelId = queryConditionPanelId;
	}

	public Integer getPageTotal() {
		return this.pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public PageButton getFirst() {
		return this.first;
	}

	public void setFirst(PageButton first) {
		this.first = first;
	}

	public PageButton getPrev() {
		return this.prev;
	}

	public void setPrev(PageButton prev) {
		this.prev = prev;
	}

	public PageButton getGotoPage() {
		return this.gotoPage;
	}

	public void setGotoPage(PageButton gotoPage) {
		this.gotoPage = gotoPage;
	}

	public PageButton getNext() {
		return this.next;
	}

	public void setNext(PageButton next) {
		this.next = next;
	}

	public PageButton getEnd() {
		return this.end;
	}

	public void setEnd(PageButton end) {
		this.end = end;
	}

	public PageButton getRefresh() {
		return this.refresh;
	}

	public void setRefresh(PageButton refresh) {
		this.refresh = refresh;
	}
}
