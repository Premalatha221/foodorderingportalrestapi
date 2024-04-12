package com.example.review2.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.review2.model.Food;
import com.example.review2.repository.FoodRepo;
import java.util.List;
@Service
public class FoodService {
     @Autowired
     FoodRepo avt;
     public Food create(Food em){
      return avt.save(em);
     }
     public List<Food> getAll(){
      return avt.findAll();
     }
     public Food getId(int fid){
      return avt.findById(fid).orElse(null);
     }
     public List<Food> getUsersWithPrice() {
        return avt.findByPrice();
    }
     public boolean update(int fid,Food eee){
          if(this.getId(fid)==null)
          {
              return false;
          }
          try{
              avt.save(eee);
          }
          catch(Exception ex)
          {
              return false;
          }
          return  true;
     }
     public boolean delete(int fid){
          if(this.getId(fid)==null){
             return false;
          }
          avt.deleteById(fid);
          return true;
     }
     //sorting by field
    public List<Food> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return avt.findAll(sort);
    }

    //pagination
    public List<Food> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return avt.findAll(page).getContent();
    }

    //sorting and pagination
    public List<Food> getsort(int pageNumber,int pageSize,String field)
    {          return avt.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
}