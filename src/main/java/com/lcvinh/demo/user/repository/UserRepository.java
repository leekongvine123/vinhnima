package com.lcvinh.demo.user.repository;

import com.lcvinh.demo.base.BaseDao;
import com.lcvinh.demo.user.entity.User;
import jakarta.ejb.Stateless;

@Stateless
public class UserRepository extends BaseDao<User> {



        public UserRepository() {
            super(User.class);
        }

        public User findByEmail(String email) {
            return  em.createQuery("SELECT u FROM User u WHERE u.email = :email",User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }
}
