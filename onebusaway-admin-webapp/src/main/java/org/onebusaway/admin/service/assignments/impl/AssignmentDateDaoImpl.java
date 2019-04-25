/**
 * Copyright (C) 2019 Cambridge Systematics, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.admin.service.assignments.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.onebusaway.admin.model.assignments.AssignmentDate;
import org.onebusaway.admin.service.assignments.AssignmentDateDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AssignmentDateDaoImpl implements AssignmentDateDao {

    protected static Logger _log = LoggerFactory.getLogger(AssignmentDateDaoImpl.class);
    private SessionFactory _sessionFactory;

    @Autowired
    @Qualifier("assignmentSessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        _sessionFactory = sessionFactory;
    }

    @Override
    public List<AssignmentDate> getAll() {
        return getSession().createCriteria(AssignmentDate.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public AssignmentDate getAssignmentDate(String key) {
        return (AssignmentDate) getSession().get(AssignmentDate.class, key);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void save(AssignmentDate assignmentDate) {
        getSession().saveOrUpdate(assignmentDate);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveAll(List<AssignmentDate> assignmentDateList) {
        for(AssignmentDate assignmentDate : assignmentDateList){
            getSession().saveOrUpdate(assignmentDate);
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(AssignmentDate assignmentDate) {
        getSession().delete(assignmentDate);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteAll() {
        Query query = getSession().createQuery("DELETE from AssignmentDate");
        query.executeUpdate();
    }

    private Session getSession(){
        return _sessionFactory.getCurrentSession();
    }
}
