package com.demo.restaurantMS.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AllTheResponses {
    public boolean hasError;
    public String content;
    public String message;
}
