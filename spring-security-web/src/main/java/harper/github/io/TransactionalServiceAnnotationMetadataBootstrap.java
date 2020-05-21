package harper.github.io;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@Service
@Repository
@Controller
public class TransactionalServiceAnnotationMetadataBootstrap {

    public static void main(String[] args) throws IOException {

        String name = TransactionalServiceAnnotationMetadataBootstrap.class.getName();

        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(name);
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        annotationMetadata.getAnnotationTypes().forEach(annotationMetadataType -> {
            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationMetadataType);
            metaAnnotationTypes.forEach(metaAnnotationType -> {
                System.out.printf("注解@%s 元注解@%s\n",annotationMetadataType,metaAnnotationType);
            } );

        });

    }
}
