package com.example.springbootdemo.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
public class MediaTypeUtils {
    private static final String PDF_CONTENT_TYPE = "application/pdf";
    private static final String XLSX_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final String XLS_CONTENT_TYPE = "application/vnd.ms-excel";
    private static final String DOCX_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    private static final String DOC_CONTENT_TYPE = "application/msword";
    private static final String PPTX_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    private static final String PPT_CONTENT_TYPE = "application/vnd.ms-powerpoint";
    private static final String TXT_CONTENT_TYPE = "text/plain";
    private static final String PNG_CONTENT_TYPE = "image/png";
    private static final String JPG_CONTENT_TYPE = "image/jpeg";
    public static MediaType getMediaTypeForFileName(HttpServletRequest request, String fileName) {
        String mimeType = request.getServletContext().getMimeType(fileName);
        MediaType mediaType = MediaType.parseMediaType(mimeType);
        // 如果文件类型未知，则根据文件扩展名进行设置
        if (mediaType.equals(MediaType.APPLICATION_OCTET_STREAM)) {
            if (fileName.endsWith(".pdf")) {
                mediaType = MediaType.parseMediaType(PDF_CONTENT_TYPE);
            } else if (fileName.endsWith(".xlsx")) {
                mediaType = MediaType.parseMediaType(XLSX_CONTENT_TYPE);
            } else if (fileName.endsWith(".xls")) {
                mediaType = MediaType.parseMediaType(XLS_CONTENT_TYPE);
            } else if (fileName.endsWith(".docx")) {
                mediaType = MediaType.parseMediaType(DOCX_CONTENT_TYPE);
            } else if (fileName.endsWith(".doc")) {
                mediaType = MediaType.parseMediaType(DOC_CONTENT_TYPE);
            } else if (fileName.endsWith(".pptx")) {
                mediaType = MediaType.parseMediaType(PPTX_CONTENT_TYPE);
            } else if (fileName.endsWith(".ppt")) {
                mediaType = MediaType.parseMediaType(PPT_CONTENT_TYPE);
            } else if (fileName.endsWith(".txt")) {
                mediaType = MediaType.parseMediaType(TXT_CONTENT_TYPE);
            } else if (fileName.endsWith(".png")) {
                mediaType = MediaType.parseMediaType(PNG_CONTENT_TYPE);
            } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
                mediaType = MediaType.parseMediaType(JPG_CONTENT_TYPE);
            }
        }
        return mediaType;
    }
}