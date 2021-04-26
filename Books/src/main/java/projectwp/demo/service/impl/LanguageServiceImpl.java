package projectwp.demo.service.impl;
import org.springframework.stereotype.Service;
import projectwp.demo.model.Language;
import projectwp.demo.repository.LanguageRepository;
import projectwp.demo.service.LanguageService;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> listAll() {
        return this.languageRepository.findAll();

    }
}
