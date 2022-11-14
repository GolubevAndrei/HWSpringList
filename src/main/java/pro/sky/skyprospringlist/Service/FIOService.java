package pro.sky.skyprospringlist.Service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.skyprospringlist.Exeption.IncorrectFIOExeption;

@Service
public class FIOService {

    public String ChecName(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new IncorrectFIOExeption();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }

    public String ChecSureName(String sureName) {
        String[] sureNames = sureName.split("-");
        for (int i = 0; i < sureName.length(); i++) {
            if (!StringUtils.isAlpha(sureName)) {
                throw new IncorrectFIOExeption();
            }
            sureNames[i] = StringUtils.capitalize(sureName.toLowerCase());
        }
        return String.join("-", sureNames);
    }
}
