package cn.itlemon.algorithm.model.animals;

/**
 * 宠物基础类
 *
 * @author jiangpingping
 * @date 2020/5/18 22:18
 */
public abstract class AbstractPet {

    private final String type;

    public AbstractPet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
