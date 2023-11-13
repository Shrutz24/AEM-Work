package com.eureka.core.models.impl;


import com.eureka.core.models.AuthorBooks;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.*;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = AuthorBooks.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class AuthorBooksImpl implements  AuthorBooks{

    @Inject
    @Via("resource")
    Resource componentResource;

    @ValueMapValue
    @Via("resource")
    @Default(values = "Shruti")
    private String authorname;

    @ValueMapValue
    @Via("resource")
    private List<String> books;

    @Override
    public String getAuthorName() {
        return authorname;
    }

    @Override
    public List<String> getAuthorBooks() {
        if(books != null){
            return new ArrayList<String>(books);
        }
        else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Map<String, String>> getBookDetailsWithMap() {
        List<Map<String,String>> bookDetailsWithMap = new ArrayList<>();
        try {
            Resource bookDetail  = componentResource.getChild("bookdetailswithmap");
            if(bookDetail != null){
                for (Resource book : bookDetail.getChildren()){
                    Map<String,String> bookMap = new HashMap<>();
                    bookMap.put("bookname", book.getValueMap().get("bookname",String.class));
                    bookMap.put("booksubject", book.getValueMap().get("booksubject",String.class));
                    bookMap.put("publishyear", book.getValueMap().get("publishyear",String.class));
                    bookDetailsWithMap.add(bookMap);
                }
            }
        }catch (Exception e){
           System.out.println("error");
        }
        return bookDetailsWithMap;
    }
}
