package com.space;

import io.micronaut.http.annotation.*;

@Controller("/art")
public class ArtController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}