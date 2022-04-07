package com.mars.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class FileSystemStorageUtil {

    @Value("${resource.path}")
    private Path rootLocation;

    @Value("${resource.rootUrl}")
    private String rootUrl;

    public Resource loadAsResource(String fileName) {
        try {
            Path file = load(fileName);
            Resource resource = new UrlResource(file.toUri());

            boolean isAvailable = resource.exists() || resource.isReadable();
            if (isAvailable) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("can't read file " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("invalid format URL");
        }

    }

    public Path load(String fileName) {
        return rootLocation.resolve(fileName);
    }

    public String store(MultipartFile file, UUID fileId) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("file is empty");
        }

        String ext = extractFileExtension(file);

        String newFileName = fileId.toString() + ext;

        Path destinationFile = this.rootLocation.resolve(Paths.get(newFileName))
                .normalize()
                .toAbsolutePath();

        if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
            throw new StorageException("can't store file outside current directory");
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new StorageException("fail to store file");
        }

        return rootUrl + newFileName;


    }

    private String extractFileExtension(MultipartFile file) {
        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
    }
}
