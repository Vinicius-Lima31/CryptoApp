package com.gm2.cryptoapp.repository;

import com.gm2.cryptoapp.dto.coinTransationDTO;
import com.gm2.cryptoapp.entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableAutoConfiguration
public class coinRepository {

    // Pegar o EntityManager
    // Constructor do EntityManager (instanciando)
    @Autowired
    private EntityManager entityManager;


    // INSERT
    @Transactional
    public Coin insert(Coin coin){
        entityManager.persist(coin);
        return coin;
    }

    // UPDATE
    @Transactional
    public Coin update(Coin coin) {
        entityManager.merge(coin);
        return coin;
    }

    // SELECT DE TUDO
    @Transactional
    public List<coinTransationDTO> getAll(){
        // jpql é parecido com SQL, mas não é a mesma coisa, mas com ele fazemos uma consulta
        String jpql = "select new com.gm2.cryptoapp.dto.coinTransationDTO(c.name, sum(c.quantity)) from Coin c group by c.name";

        // entityManager.createQuery ele retorna um TypedQuery<T> com isso temos
        TypedQuery<coinTransationDTO> query = entityManager.createQuery(jpql, coinTransationDTO.class);

        return query.getResultList();
    }

    // SELECT POR NAME
    @Transactional
    public List<Coin> getByName(String name){
        String jpql = "select c from Coin c where c.name like :name";

        TypedQuery<Coin> query = entityManager.createQuery(jpql, Coin.class);

        // Substituindo o :name pelo name daqui, lembrando que ele vem dos parametros
        query.setParameter("name", "%" + name + "%");

        return query.getResultList();
    }

    // SELECT GERAL
    @Transactional
    public List<Coin> getAllTheSame(){
        String jpql = "select c from Coin c";
        TypedQuery<Coin> query = entityManager.createQuery(jpql, Coin.class);

        return query.getResultList();
    }

/*
    // SELECT POR ID
    public List<Coin> getById(int id){
        String jpql = "select c from Coin c where c.id= :id";

        TypedQuery<Coin> query = entityManager.createQuery(jpql, Coin.class);

        query.setParameter("id", id);

        return query.getResultList();
    }


 */


   // DELETE
    @Transactional
    public boolean remove(int id) {
        Coin coin = entityManager.find(Coin.class, id);

        /* Não entendi o pq desse if, mas vou deixar comentado aqui!!
            if(!entityManager.contains(coin)){
                coin = entityManager.merge(coin);
            }
         */

        entityManager.remove(coin);
        return true;
    }

}
