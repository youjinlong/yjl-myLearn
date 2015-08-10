package com.tuch.common.util;



/**

 * 
 * @author chenkunpeng
 *
 */
public class PageUtil {
	//as  map  key
	public  final String PAGE="page";
	public  final String SIZE="size";
	public  final String TOTAL="total";
	public  final String TOTALPage="maxPages";
	public  final String CONTENTLENGTH="contentLength";
	
	
	//the current count of all page
	private  int page=1;
	
	//default size is 10
	private  int size=10; 
	
	//total entities in the table
	private Long total=0L;
	
	
	private Long totalPage;

	public PageUtil(Integer page, Integer size, Long total) {
		super();
		if(page!=null)
		   this.page = page;
		if(size!=null)
		   this.size = size;
		if(total!=null)
		  this.total = total;
	}
	
	public PageUtil(Long total) {
		super();
		if(total!=null)
		  this.total = total;
	}
	
	/**
	 * @return
	 */
	public int getEnitiesFromCount(){
		
		return (page-1) * size ;
	}
	
	/**
	 * @return
	 */
	public Long getTotalPage(){
		
		totalPage = total/size;
		if(totalPage*size < total){
			totalPage ++;
		}
		return  totalPage ;
	}
	
	
	public static void main(String[] args) {
		long l = 6 ; 
		int i = (int) l ;
		System.out.println(l);
	}

}
