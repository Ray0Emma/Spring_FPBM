package com.example.fpbm.services.ExcelServices;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploaderService {
    public void uploadFile(MultipartFile file);
}
