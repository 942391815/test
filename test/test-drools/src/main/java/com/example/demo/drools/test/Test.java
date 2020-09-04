package com.example.demo.drools.test;

import org.drools.core.io.impl.ClassPathResource;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ming on 2018/5/24.
 */
public class Test {

    public static void main(String[] args) {
        KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kb.add(new ClassPathResource("test.drl"), ResourceType.DRL);
        Collection<KnowledgePackage> collection = kb.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(collection);
        StatefulKnowledgeSession statefulSession = knowledgeBase.newStatefulKnowledgeSession();
        List<Stu> list = getStus();
        for (Stu stu : list) {
            statefulSession.insert(stu);
        }
        statefulSession.fireAllRules();
        statefulSession.dispose();
        System.out.println("end....");
    }

    public static List<Stu> getStus() {
        List<Stu> stus = new ArrayList<>();
        stus.add(new Stu("张三", 16, "male"));
//        stus.add(new Stu("huhu", 18, "male"));
//        stus.add(new Stu("王五", 32, "male"));
//        stus.add(new Stu("张红", 23, "female"));
//        stus.add(new Stu("李四", 35, "male"));
//        stus.add(new Stu("张小雅", 31, "female"));
        return stus;
    }
}