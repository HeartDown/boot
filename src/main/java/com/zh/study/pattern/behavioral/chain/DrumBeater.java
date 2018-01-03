package com.zh.study.pattern.behavioral.chain;

import javax.swing.*;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by zhangheng on 2017/11/26.
 */
public class DrumBeater {
    public static void main(String[] args) {
        Player player = new PlayA(new PlayB(new PlayC(new PlayA(null))));
        player.handle(3);
        List<Integer> list = Stream.of(asList(1,2),asList(3,4))
                                .flatMap(integers -> integers.stream())
                .collect(toList());
        list.forEach(System.out::print);
    }
}
