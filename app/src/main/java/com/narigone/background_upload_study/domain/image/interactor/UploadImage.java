package com.narigone.background_upload_study.domain.image.interactor;

import com.narigone.background_upload_study.domain.image.entity.Image;
import com.narigone.background_upload_study.domain.image.repository.ImageRepository;
import com.narigone.background_upload_study.domain.shared.executor.PostExecutionThread;
import com.narigone.background_upload_study.domain.shared.executor.ThreadExecutor;
import com.narigone.background_upload_study.domain.shared.interactor.UseCase;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UploadImage extends UseCase<Image, UploadImage.Params> {

    private final ImageRepository imageRepository;

    @Inject
    public UploadImage(ImageRepository imageRepository, ThreadExecutor threadExecutor,
                PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.imageRepository = imageRepository;
    }

    @Override
    protected Observable<Image> buildUseCaseObservable(Params params) {
        return this.imageRepository.upload(params.image);
    }

    public static final class Params {

        private final Image image;

        private Params(Image image) {
            this.image = image;
        }

        public static Params fromImage(Image image) {
            return new Params(image);
        }
    }
}
