package com.example.review2.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.review2.model.Food;
import com.example.review2.service.FoodService;




@RestController
public class FoodController{
    @Autowired
    FoodService evt;
    @PostMapping("/post/food")
    public ResponseEntity<Food>addelements(@RequestBody Food n)
    {
        Food evty=evt.create(n);
        return new ResponseEntity<>(evty,HttpStatus.CREATED);
    }
    @GetMapping("/get/food")
    public ResponseEntity<List<Food>> showinfo()
    {
        return new ResponseEntity<>(evt.getAll(),HttpStatus.OK);
    }
    @GetMapping("/get/food/{fid}")
    public ResponseEntity<Food> getById(@PathVariable Integer fid)
    {
        Food objj=evt.getId(fid);
        return new ResponseEntity<>(objj,HttpStatus.OK);
    }
    @PutMapping("/put/food/{fid}")
    public ResponseEntity<Food> putMethodName(@PathVariable("fid") int fid, @RequestBody Food ee) {
        if(evt.update(fid,ee) == true)
        {
            return new ResponseEntity<>(ee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        
    }
    @DeleteMapping("/delete/food/{fid}")
    public ResponseEntity<Boolean> delete(@PathVariable("fid") int fid)
    {
        if(evt.delete(fid) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/price")
    public List<Food> getUsersWithFoodPrice() {
        return evt.getUsersWithPrice();
    }
   //sorting
   @GetMapping("/api/food/sortBy/{field}")
   public List<Food> g(@PathVariable String field)
   {
       return evt.sort(field);
   }

   //pagination
   @GetMapping("/api/food/{offset}/{pagesize}")
   public List<Food> get(@PathVariable int offset,@PathVariable int pagesize)
   {
       return evt.page(pagesize, offset);
   }
   
   //sorting and pagination
   @GetMapping("/api/food/{offset}/{pagesize}/{field}")
   public List<Food> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
   {
       return evt.getsort(offset,pagesize,field);
   }
}