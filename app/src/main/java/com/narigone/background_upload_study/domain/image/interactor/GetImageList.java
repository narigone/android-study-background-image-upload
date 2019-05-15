package com.narigone.background_upload_study.domain.image.interactor;

import com.narigone.background_upload_study.domain.image.entity.Image;
import com.narigone.background_upload_study.domain.image.repository.ImageRepository;
import com.narigone.background_upload_study.domain.shared.executor.PostExecutionThread;
import com.narigone.background_upload_study.domain.shared.executor.ThreadExecutor;
import com.narigone.background_upload_study.domain.shared.interactor.UseCase;

import java.util.List;
import javax.inject.Inject;

import io.reactivex.Observable;

public class GetImageList extends UseCase<List<Image>, Void> {

    private final ImageRepository imageRepository;

    @Inject
    public GetImageList(ImageRepository imageRepository, ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.imageRepository = imageRepository;
    }

    @Override
    protected Observable<List<Image>> buildUseCaseObservable(Void unused) {
        return this.imageRepository.imageList();
    }
}
