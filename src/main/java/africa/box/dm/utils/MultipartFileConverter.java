package africa.box.dm.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MultipartFileConverter implements MultipartFile {
    private final byte[] fileContent;
    private final String extension;
    private final String contentType;
    private final String filename;

    public MultipartFileConverter(String base64, String dataUri) {
        this.fileContent = Base64.getDecoder().decode(base64.getBytes(StandardCharsets.UTF_8));
        this.extension = dataUri.split(";")[0].split("/")[1];
        this.contentType = dataUri.split(";")[0].split(":")[1];
        this.filename = dataUri.split(";")[1];
    }


    public MultipartFileConverter(String base64,String filename, String extension, String contentType){
        this.fileContent = Base64.getDecoder().decode(base64.getBytes(StandardCharsets.UTF_8));
        this.extension = extension;
        this.contentType = contentType;
        this.filename = filename;
    }

    private MultipartFileConverter(byte[] content, String filename, String extension, String contentType
                                   ){
        this.fileContent = content;
        this.extension = extension;
        this.contentType = contentType;
        this.filename = filename;
    }

    public static MultipartFileConverter fromBytes(byte[] content, String filename, String extension,
                                                   String contentType){
        return new MultipartFileConverter(
                content, filename, extension, contentType
        );
    }

    @Override
    public String getName() {
        return "param_" + System.currentTimeMillis();
    }

    @Override
    public String getOriginalFilename() {
        //return "file_" + System.currentTimeMillis() + "." + extension;
        return filename;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public boolean isEmpty() {
        return fileContent == null || fileContent.length == 0;
    }

    @Override
    public long getSize() {
        return fileContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return fileContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(fileContent);
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(fileContent);
        }
    }
}
