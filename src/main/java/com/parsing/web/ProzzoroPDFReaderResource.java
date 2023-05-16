package com.parsing.web;

import com.parsing.pdf.download.PDFDownloader;
import com.parsing.pdf.parsing.ParsingPDFService;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ProzzoroPDFReaderResource {

    private final ParsingPDFService parsingPDFService;
    private final PDFDownloader pdfDownloader;


    @PostMapping(value = "/api/pdf/extractText", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String extractTextFromPDFFile(@RequestPart(value = "upload") MultipartFile file) throws IOException, TesseractException {
        return parsingPDFService.parseProzorroFile(file);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/api/pdf/download", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void downloadPDFFile(@RequestParam(value = "uri") String uri) {
        pdfDownloader.downloadPDF(uri);
    }
}
