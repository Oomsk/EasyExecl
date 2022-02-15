package com.example.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.example.easyexcel.listener.NoModleDataListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 *  Omsk
 *  2022-2-15 10:06:09
 */

@RestController
@RequestMapping("excel")
@Slf4j
public class EasyExeclControoler {


    @PostMapping("reader")
    public ResponseEntity ExeclReader(@RequestParam("file") MultipartFile file) {



        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, new NoModleDataListener()).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("ok");
    }

}
