package com.narigone.background_upload_study.domain.image.repository;


import com.narigone.background_upload_study.domain.image.entity.Image;
import io.reactivex.Observable;
import java.util.List;


public interface ImageRepository {
    Observable<List<Image>> imageList();
    Observable<Image> image(int id);
    Observable<Image> upload(Image image);
}
