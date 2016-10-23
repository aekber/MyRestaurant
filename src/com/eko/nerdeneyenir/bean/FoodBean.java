package com.eko.nerdeneyenir.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eko.nerdeneyenir.model.Food;
import com.eko.nerdeneyenir.model.FoodCategory;
import com.eko.nerdeneyenir.model.FoodImage;
import com.eko.nerdeneyenir.model.Restaurant;
import com.eko.nerdeneyenir.model.RestaurantAddress;
import com.eko.nerdeneyenir.service.IFoodCategoryService;
import com.eko.nerdeneyenir.service.IFoodImageService;
import com.eko.nerdeneyenir.service.IFoodService;
import com.eko.nerdeneyenir.service.IRestaurantService;



public class FoodBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private static Logger logger = LoggerFactory.getLogger(FoodBean.class);
	
	private IFoodService foodService;
	private IFoodImageService foodImageService;
	private IFoodCategoryService foodCategoryService;
	private IRestaurantService restaurantService;
	
	private List<FoodCategory> allFoodCategories = new ArrayList<FoodCategory>();
	private List<Food> allFoods = new ArrayList<Food>();
	private List<FoodImage> allFoodImages = new ArrayList<FoodImage>();
	private List<Food> foodsByRestaurant = new ArrayList<Food>();
	private List<Restaurant> restaurantsByFoods = new ArrayList<Restaurant>();
	private Set<Restaurant> allRestaurants = new HashSet<Restaurant>();
    private Set<SelectItem> firstList = new LinkedHashSet<SelectItem>();
    private Set<SelectItem> secondList = new LinkedHashSet<SelectItem>();
    private Set<SelectItem> thirdList = new LinkedHashSet<SelectItem>();
    private Set<SelectItem> forthList = new LinkedHashSet<SelectItem>();
    private List<String> imageList = new ArrayList<String>();
    
	private String categoryForFood = "", restaurantName = "", categoryMessage = "", temp = "", food = "", 
			foodCategoryFilter, foodFilter, restaurantFilter, foodImageFilter, foodRestaurantFilter, restaurantCityFilter;
	private int page = 1;
	private Food editedFood = new Food();
	private Restaurant editedRestaurant = new Restaurant();
	private FoodCategory editedFoodCat = new FoodCategory();
	private FoodImage editedFoodImage = new FoodImage();
	private Restaurant newRestaurant;
	private Food newFood;
	private FoodImage newFoodImage;
	private FoodCategory newFoodCat;
	
	public FoodBean(){
		//editedFood.setFoodCategory(new FoodCategory());
		//editedFood.setRestaurant(new Restaurant());
		
//		newFood.setFoodCategory(new FoodCategory());
//		newFood.setRestaurant(new Restaurant());
//		
//		newRestaurant.setRestaurantAddress(new RestaurantAddress());
//		
//		newFoodImage.setFood(new Food());
	}
	
	public void setFoodService(IFoodService foodService) {
		this.foodService = foodService;
	}
	
	public void setFoodImageService(IFoodImageService foodImageService) {
		this.foodImageService = foodImageService;
	}

	public void setFoodCategoryService(IFoodCategoryService foodCategoryService) {
		this.foodCategoryService = foodCategoryService;
	}

	public void setRestaurantService(IRestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	public String getFoodFilter() {
		return foodFilter;
	}

	public void setFoodFilter(String foodFilter) {
		this.foodFilter = foodFilter;
	}

	public String getFoodCategoryFilter() {
		return foodCategoryFilter;
	}

	public void setFoodCategoryFilter(String foodCategoryFilter) {
		this.foodCategoryFilter = foodCategoryFilter;
	}

	public String getRestaurantFilter() {
		return restaurantFilter;
	}

	public void setRestaurantFilter(String restaurantFilter) {
		this.restaurantFilter = restaurantFilter;
	}

	public String getFoodImageFilter() {
		return foodImageFilter;
	}

	public void setFoodImageFilter(String foodImageFilter) {
		this.foodImageFilter = foodImageFilter;
	}

	public String getFoodRestaurantFilter() {
		return foodRestaurantFilter;
	}

	public void setFoodRestaurantFilter(String foodRestaurantFilter) {
		this.foodRestaurantFilter = foodRestaurantFilter;
	}

	public String getRestaurantCityFilter() {
		return restaurantCityFilter;
	}

	public void setRestaurantCityFilter(String restaurantCityFilter) {
		this.restaurantCityFilter = restaurantCityFilter;
	}

	public String getCategoryForFood() {
		return categoryForFood;
	}

	public void setCategoryForFood(String categoryForFood) {
		this.categoryForFood = categoryForFood;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Set<SelectItem> getFirstList() {
		return firstList;
	}

	public void setFirstList(Set<SelectItem> firstList) {
		this.firstList = firstList;
	}

	public Set<SelectItem> getSecondList() {
		return secondList;
	}

	public void setSecondList(Set<SelectItem> secondList) {
		this.secondList = secondList;
	}

	public Set<SelectItem> getThirdList() {
		return thirdList;
	}

	public void setThirdList(Set<SelectItem> thirdList) {
		this.thirdList = thirdList;
	}

	public Set<SelectItem> getForthList() {
		return forthList;
	}

	public void setForthList(Set<SelectItem> forthList) {
		this.forthList = forthList;
	}

	public List<Food> getAllFoods() {
		return allFoods;
	}

	public void setAllFoods(List<Food> allFoods) {
		this.allFoods = allFoods;
	}

	public Food getEditedFood() {
		return editedFood;
	}

	public void setEditedFood(Food editedFood) {
		this.editedFood = editedFood;
	}

	public Restaurant getEditedRestaurant() {
		return editedRestaurant;
	}

	public void setEditedRestaurant(Restaurant editedRestaurant) {
		this.editedRestaurant = editedRestaurant;
	}

	public Food getNewFood() {
		return newFood;
	}

	public void setNewFood(Food newFood) {
		this.newFood = newFood;
	}

	public Restaurant getNewRestaurant() {
		return newRestaurant;
	}

	public void setNewRestaurant(Restaurant newRestaurant) {
		this.newRestaurant = newRestaurant;
	}

	public FoodImage getEditedFoodImage() {
		return editedFoodImage;
	}

	public void setEditedFoodImage(FoodImage editedFoodImage) {
		this.editedFoodImage = editedFoodImage;
	}

	public FoodImage getNewFoodImage() {
		return newFoodImage;
	}

	public void setNewFoodImage(FoodImage newFoodImage) {
		this.newFoodImage = newFoodImage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Food> getFoodsByRestaurant() {
		return foodsByRestaurant;
	}

	public void setFoodsByRestaurant(List<Food> foodsByRestaurant) {
		this.foodsByRestaurant = foodsByRestaurant;
	}

	public List<Restaurant> getRestaurantsByFoods() {
		return restaurantsByFoods;
	}

	public void setRestaurantsByFoods(List<Restaurant> restaurantsByFoods) {
		this.restaurantsByFoods = restaurantsByFoods;
	}
    
	public Set<Restaurant> getAllRestaurants() {
		return allRestaurants;
	}

	public void setAllRestaurants(Set<Restaurant> allRestaurants) {
		this.allRestaurants = allRestaurants;
	}

	public List<FoodCategory> getAllFoodCategories() {
		return allFoodCategories;
	}

	public void setAllFoodCategories(List<FoodCategory> allFoodCategories) {
		this.allFoodCategories = allFoodCategories;
	}

	public List<FoodImage> getAllFoodImages() {
		return allFoodImages;
	}

	public void setAllFoodImages(List<FoodImage> allFoodImages) {
		this.allFoodImages = allFoodImages;
	}

	public FoodCategory getEditedFoodCat() {
		return editedFoodCat;
	}

	public void setEditedFoodCat(FoodCategory editedFoodCat) {
		this.editedFoodCat = editedFoodCat;
	}

	public FoodCategory getNewFoodCat() {
		return newFoodCat;
	}

	public void setNewFoodCat(FoodCategory newFoodCat) {
		this.newFoodCat = newFoodCat;
	}

	public String getCategoryMessage() {
		return categoryMessage;
	}

	public void setCategoryMessage(String categoryMessage) {
		this.categoryMessage = categoryMessage;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}
	
    public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public void checkNewCategoryName(AjaxBehaviorEvent event){
    	if(isCategoryNameExist(this.getNewFoodCat().getName())){
    		this.setCategoryMessage("Güzel askim bak tabloda bu kategoriden zaten var");
    	} else{
    		this.setCategoryMessage("");
    	}
    }
    
	private boolean isCategoryNameExist(String name) {
    	if(name != null && !"".equals(name)){
			for(FoodCategory a : allFoodCategories){
				if(name.equalsIgnoreCase(a.getName())){
					return true;
				}
			}
    	}
		return false;
	}

	public void valueChangedForRestaurantList(ValueChangeEvent event) {
		forthList.clear();
        Object selectedValue = event.getNewValue();
        if (null != selectedValue && !"".equals(selectedValue.toString())) {    		
        	Restaurant r = getRestaurantByName(selectedValue.toString());
        	SelectItem item = new SelectItem(""); 
        	forthList.add(item);

        	for(Food f : r.getFoods()){
                item = new SelectItem(f.getFoodName()); 
                forthList.add(item);
        	}
        	
        } else{
        	forthList.clear();
    		System.out.println("***********************************************");
    		System.out.println("event.getNewValue() bos geldiiiiii-valueChangedForRestaurantList");
    		System.out.println("***********************************************");
    	}
    }
	
	private Restaurant getRestaurantByName(String value) {
		for(Restaurant r : allRestaurants){
			if(r.getName().equals(value)){
				return r;
			}
		}
		return null;
	}

	private FoodCategory getFoodCategoryByName(String value) {
		for(FoodCategory category : allFoodCategories){
			if(category.getName().equals(value)){
				return category;
			}
		}
		return null;
	}

	public void updateFood(){
		Integer foodId = this.getEditedFood().getFoodId();
		String restaurant = this.getEditedFood().getRestaurant().getName();
		String foodCategory = this.getEditedFood().getFoodCategory().getName();
		
		//this.getEditedFood().setRestaurant(restaurantService.findByRestaurantName(restaurant));
		//this.getEditedFood().setFoodCategory(new FoodCategory());
		
		FoodCategory yeniFc = foodCategoryService.findByFoodCategoryName(foodCategory);
		FoodCategory eskiFc = foodCategoryService.findById(this.getEditedFood().getFoodCategory().getFoodCategoryId());
		
		Restaurant yeniR = restaurantService.findByRestaurantName(restaurant);
		Restaurant eskiR = restaurantService.findById(this.getEditedFood().getRestaurant().getRestaurantId());
		
		if(!yeniFc.getFoodCategoryId().toString().equals(eskiFc.getFoodCategoryId().toString())){
			yeniFc.getFoodList().add(this.getEditedFood());
			eskiFc.getFoodList().remove(this.getEditedFood());
			this.getEditedFood().setFoodCategory(yeniFc);
		}
		
		if(!yeniR.getRestaurantId().toString().equals(eskiR.getRestaurantId().toString())){
			yeniR.getFoods().add(this.getEditedFood());
			eskiR.getFoods().remove(this.getEditedFood());
			this.getEditedFood().setRestaurant(yeniR);
		}
		
		this.getEditedFood().setUpdateDate(new Date());
		foodService.mergeFood(this.getEditedFood());
		
		if(!yeniFc.getFoodCategoryId().toString().equals(eskiFc.getFoodCategoryId().toString())){
			updateFoodCatFoods(foodId, yeniFc, eskiFc);
		}
		
		if(!yeniR.getRestaurantId().toString().equals(eskiR.getRestaurantId().toString())){
			updateRestaurantFoods(foodId, yeniR, eskiR);
		}
	}

	private void updateRestaurantFoods(Integer foodId, Restaurant yeniR, Restaurant eskiR) {
		for(Food f : allFoods){
			if(f.getFoodId().toString().equals(foodId.toString())){
				f.setRestaurant(yeniR);
				break;
			}
		}
		
		for(Restaurant r : allRestaurants){
			if(r.getRestaurantId().toString().equals(eskiR.getRestaurantId().toString()) && !r.getName().equals(eskiR.getName())){
				r.setName(eskiR.getName());
				r.getFoods().remove(this.getEditedFood());
				break;
			}
		}
		
		for(Restaurant r : allRestaurants){
			if(r.getRestaurantId().toString().equals(yeniR.getRestaurantId().toString())){
				r.getFoods().add(this.getEditedFood());
				break;
			}
		}
		
	}

	private void updateFoodCatFoods(Integer foodId, FoodCategory yeniFc, FoodCategory eskiFc) {
		for(Food f : allFoods){
			if(f.getFoodName().toString().equals(foodId.toString())){
				f.setFoodCategory(yeniFc);
				break;
			}
		}
		
		for(FoodCategory fc : allFoodCategories){
			if(fc.getFoodCategoryId().toString().equals(eskiFc.getFoodCategoryId().toString()) && !fc.getName().equals(eskiFc.getName())){
				fc.setName(eskiFc.getName());
				fc.getFoodList().remove(this.getEditedFood());
				break;
			}
		}
		
		for(FoodCategory fc : allFoodCategories){
			if(fc.getFoodCategoryId().toString().equals(yeniFc.getFoodCategoryId().toString())){
				fc.getFoodList().add(this.getEditedFood());
				break;
			}
		}
	}
	
	public void insertFoodCategory(){
		foodCategoryService.addNewFoodCategory(this.getNewFoodCat());
		allFoodCategories.add(this.getNewFoodCat());
		firstList.add(new SelectItem(this.getNewFoodCat().getName()));
		newFoodCat = new FoodCategory();
		
	}
	
	public void deleteFoodCategory(){
		foodCategoryService.deleteFoodCategory(this.getEditedFoodCat());
		allFoodCategories.remove(this.getEditedFoodCat());
	}
	
	public void updateFoodCategory(){
		foodCategoryService.mergeFoodCategory(this.getEditedFoodCat());
		editedFoodCat = new FoodCategory();
	}
	
	public String insertFood(){
		FoodCategory fc = getFoodCategoryByName(this.getNewFood().getFoodCategory().getName());
		Restaurant r = getRestaurantByName(this.getNewFood().getRestaurant().getName());
		this.getNewFood().setFoodCategory(fc);
		this.getNewFood().setRestaurant(r);
		this.getNewFood().setInsertDate(new Date());
		this.getNewFood().setFoodActive(true);
		this.getNewFood().setPopularity(0);
		foodService.addNewFood(this.getNewFood());
		
		allFoods.add(this.getNewFood());
		if(fc.getFoodList() == null){
			fc.setFoodList(new ArrayList<Food>());
		}
        fc.getFoodList().add(this.getNewFood());
        
        if(r.getFoods() == null){
        	r.setFoods(new ArrayList<Food>());
        }
        r.getFoods().add(this.getNewFood());
        newFood = new Food();
		return null;
	}
	
	public String updateRestaurant(){
		this.getEditedRestaurant().setUpdateDate(new Date());
		restaurantService.mergeRestaurant(this.getEditedRestaurant());
		
		return null;
	}
	
	public String insertRestaurant(){
		this.getNewRestaurant().setInsertDate(new Date());
		this.getNewRestaurant().setUpdateDate(new Date());
		restaurantService.addNewRestaurant(this.getNewRestaurant());
		
		allRestaurants.add(this.getNewRestaurant());
		thirdList.add(new SelectItem(this.getNewRestaurant().getName()));
		newRestaurant = new Restaurant();
		return null;
	}
	
	public String insertFoodImage(){
		Food f = getFoodByNameAndRestaurant(this.getFood(), this.getTemp());

		for(String img : imageList){
			FoodImage image = new FoodImage();
			image.setFood(f);
			image.setInsertDate(new Date());
			image.setFoodImage(img);

			foodImageService.addNewFoodImage(image);
			allFoodImages.add(image);
			f.getFoodImages().add(image);
		}
		
        newFoodImage = new FoodImage();
        imageList.clear();
		return null;
	}
	
	public void updateFoodImage(){
		foodImageService.mergeFoodImage(this.getEditedFoodImage());
		editedFoodImage = new FoodImage();	
	}
	
	public void deleteFoodImage(){
		foodImageService.deleteFoodImage(this.getEditedFoodImage());

		//File file = new File("C:\\Users\\ekber\\workspace_luna\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\NerdeNeYenir\\resources\\fimg\\" + this.getEditedFoodImage().getFoodImage());
		File file1 = new File("/usr/local/tomcat1/webapps/NerdeNeYenir/resources/fimg/" + this.getEditedFoodImage().getFoodImage());
		File file2 = new File("/usr/local/tomcat2/webapps/NerdeNeYenir/resources/fimg/" + this.getEditedFoodImage().getFoodImage());
		File file3 = new File("/usr/local/tomcat3/webapps/NerdeNeYenir/resources/fimg/" + this.getEditedFoodImage().getFoodImage());
		File file4 = new File("/usr/local/yedek/" + this.getEditedFoodImage().getFoodImage());
		
		if(file1.delete() && file2.delete() && file3.delete() && file4.delete()){
			System.out.println("**********" + this.getEditedFoodImage().getFoodImage() + " dosyasi silindi.*************");
		} else{
			System.out.println("**********" + this.getEditedFoodImage().getFoodImage() + " dosyasi silinemeediii.*************");
		}
		
		allFoodImages.remove(this.getEditedFoodImage());
	}
    
    private Food getFoodByNameAndRestaurant(String foodName, String restaurant) {
		for(Food food : allFoods){
			if(food.getFoodName().equals(foodName) && food.getRestaurant().getName().equals(restaurant)){
				return food;
			}
		}
		
		return null;
	}

	public void foodActivenessListener(AjaxBehaviorEvent event) {
    	Boolean value = (Boolean) ((UIInput) event.getComponent()).getValue();
        FacesContext context = FacesContext.getCurrentInstance();
        Food food = context.getApplication().evaluateExpressionGet(context, "#{article}", Food.class);

        if(value){
    		if(food.isFoodActive()){
    			food.setFoodActive(true);
    			foodService.mergeFood(food);
    			//updateAllArticlesList(article);
    			//System.out.println(article.getArticleTag() + " Makalesinin Yorumlar� aktiflestirildi...");
    		}
    	}
    	else{
    		if(!food.isFoodActive()){
    			food.setFoodActive(false);
    			foodService.mergeFood(food);
    			//updateAllArticlesList(article);
    			//System.out.println(article.getArticleTag() + " Makalesinin Yorumlar� pasiflestirildi...");
    		}
    	}
    }
    
    public void insertImageListener(FileUploadEvent event) throws IOException {
        
    	UploadedFile uploadedFile = event.getUploadedFile();

        long milisec = System.currentTimeMillis();
        String extension = uploadedFile.getName().substring(uploadedFile.getName().lastIndexOf('.') + 1);
        
        //FileOutputStream fos = new FileOutputStream("/home/ekber/workspace_javaee/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/NerdeNeYenir/resources/fimg/" + milisec + "." + extension);
        FileOutputStream fos = new FileOutputStream("/usr/local/tomcat1/webapps/NerdeNeYenir/resources/fimg/" + milisec + "." + extension); 
        fos.write(uploadedFile.getData());
        fos.close();
        
        FileOutputStream fos2 = new FileOutputStream("/usr/local/tomcat2/webapps/NerdeNeYenir/resources/fimg/" + milisec + "." + extension); 
        fos2.write(uploadedFile.getData());
        fos2.close();
        
        FileOutputStream fos3 = new FileOutputStream("/usr/local/tomcat3/webapps/NerdeNeYenir/resources/fimg/" + milisec + "." + extension); 
        fos3.write(uploadedFile.getData());
        fos3.close();
        
        FileOutputStream fos4 = new FileOutputStream("/usr/local/yedek/" + milisec + "." + extension); 
        fos4.write(uploadedFile.getData());
        fos4.close();

        imageList.add(milisec + "." + extension);
    }
    
    public void updateImageListener(FileUploadEvent event) throws Exception {
    	
    	UploadedFile uploadedFile = event.getUploadedFile();

        long milisec = System.currentTimeMillis();
        String extension = uploadedFile.getName().substring(uploadedFile.getName().lastIndexOf('.') + 1);
        
        //FileOutputStream fos = new FileOutputStream("/home/ekber/workspace_javaee/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/NerdeNeYenir/resources/fimg/" + milisec + "." + extension);
        FileOutputStream fos = new FileOutputStream("/usr/local/tomcat1/webapps/NerdeNeYenir/resources/fimg/" + milisec + "." + extension); 
        fos.write(uploadedFile.getData());
        fos.close();
        
        FileOutputStream fos2 = new FileOutputStream("/usr/local/tomcat2/webapps/NerdeNeYenir/resources/fimg/" + milisec + "." + extension); 
        fos2.write(uploadedFile.getData());
        fos2.close();
        
        FileOutputStream fos3 = new FileOutputStream("/usr/local/tomcat3/webapps/NerdeNeYenir/resources/fimg/" + milisec + "." + extension); 
        fos3.write(uploadedFile.getData());
        fos3.close();
        
        FileOutputStream fos4 = new FileOutputStream("/usr/local/yedek/" + milisec + "." + extension); 
        fos4.write(uploadedFile.getData());
        fos4.close();
        
        this.getEditedFoodImage().setFoodImage(milisec + "." + extension);

    }
    
/*
    public void paint(OutputStream os, Object data) throws IOException {
    	Integer id = (Integer) data;
        Food food = (Food) getFoodById(id);
        if(food != null && food.getFoodImage() != null){
        	os.write(food.getFoodImage());
        }
        
        <a4j:mediaOutput element="img" cacheable="false" session="false" 
        	createContent="#{foodBean.paint}" value="#{article.foodId}" />
    }
    
    private Food getFoodById(Integer id) {
		for(Food food : allFoods){
			if(food.getFoodId().equals(id)){
				return food;
			}
		}
		return null;
	}
*/
	public void restaurantActivenessListener(AjaxBehaviorEvent event) {
    	Boolean value = (Boolean) ((UIInput) event.getComponent()).getValue();
        FacesContext context = FacesContext.getCurrentInstance();
        Restaurant restaurant = context.getApplication().evaluateExpressionGet(context, "#{article}", Restaurant.class);

        if(value){
    		if(restaurant.isRestaurantActive()){
    			restaurant.setRestaurantActive(true);
    			restaurantService.mergeRestaurant(restaurant);
    			//updateAllArticlesList(article);
    			//System.out.println(article.getArticleTag() + " Makalesinin Yorumlar� aktiflestirildi...");
    		}
    	}
    	else{
    		if(!restaurant.isRestaurantActive()){
    			restaurant.setRestaurantActive(false);
    			restaurantService.mergeRestaurant(restaurant);
    			//updateAllArticlesList(article);
    			//System.out.println(article.getArticleTag() + " Makalesinin Yorumlar� pasiflestirildi...");
    		}
    	}
    }
	
	public String logout(){
		try {
			FacesContext jsf = FacesContext.getCurrentInstance();
			ExternalContext extCtxt = jsf.getExternalContext();
			HttpServletRequest req = (HttpServletRequest) extCtxt.getRequest();		
		
			req.logout();
			
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		return "index?faces-redirect=true";
	}      
	
	@PostConstruct
	public void init() {
		newFood = new Food();
		newFood.setFoodCategory(new FoodCategory());
		newFood.setRestaurant(new Restaurant());
		
		newRestaurant = new Restaurant();
		newRestaurant.setRestaurantAddress(new RestaurantAddress());
		
		newFoodImage = new FoodImage();
		newFoodImage.setFood(new Food());
		
		newFoodCat = new FoodCategory();
		
        SelectItem item2 = new SelectItem("");
        secondList.add(item2);
        
        SelectItem item3 = new SelectItem("");
        thirdList.add(item3);		
		
		SelectItem item = new SelectItem("");
		firstList.add(item);
		
		allFoodCategories = foodCategoryService.getAllFoodCategories();
		for(FoodCategory category : allFoodCategories){
	        item = new SelectItem(category.getName());
	        firstList.add(item);
	        for(Food food : category.getFoodList()){
	        	item2 = new SelectItem(food.getFoodName());
		        secondList.add(item2);
	        	allFoods.add(food);
	        	
	        	//yeni eklenen restaurantlar burda filtreye tak�l�yorre !!!
	        	
	        	if(!allRestaurants.contains(food.getRestaurant())){
	    	        item3 = new SelectItem(food.getRestaurant().getName());
	    	        thirdList.add(item3);
	        		allRestaurants.add(food.getRestaurant());
	        	}
	        	for(FoodImage image : food.getFoodImages()){
	        		allFoodImages.add(image);
	        	}
	        }
		}
	}
}
