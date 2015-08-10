package com.tuch.common.util;



public interface Paginable {

	public int getTotalCount();

	public int getTotalPage();

	public int getPageSize();

	public int getPageNo();

	public boolean isFirstPage();

	public boolean isLastPage();

	public int getNextPage();

	public int getPrePage();
}
