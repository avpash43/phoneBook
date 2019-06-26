package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.AbonentView;
import ru.phones.book.model.repositories.AbonentViewRepository;
import ru.phones.book.model.services.AbonentViewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AbonentViewServiceImpl implements AbonentViewService {

    @Autowired
    AbonentViewRepository abonentViewRepository;

    @Override
    public List<AbonentView> findAll() {
        List<AbonentView> abonentViews = new ArrayList<>();
        abonentViewRepository.findAll().forEach(abonent -> abonentViews.add(abonent));
        return abonentViews;
    }

    @Override
    public ResponseEntity<AbonentView> findById(Long abonentViewId) {
        Optional<AbonentView> optAbonentView = abonentViewRepository.findById(abonentViewId);
        if(optAbonentView.isPresent()) {
            return new ResponseEntity<>(optAbonentView.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
