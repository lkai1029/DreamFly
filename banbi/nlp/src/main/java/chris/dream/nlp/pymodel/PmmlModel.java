package chris.dream.nlp.pymodel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.InputField;
import org.jpmml.evaluator.ModelEvaluatorFactory;
import org.jpmml.evaluator.ProbabilityDistribution;
import org.jpmml.evaluator.ValueMap;
import org.jpmml.model.PMMLUtil;
import org.xml.sax.SAXException;

public class PmmlModel {
    private Evaluator modelEvaluator;

    /**
     * 通过传入 PMML 文件路径来生成机器学习模型
     *
     * @param pmmlFileName pmml 文件路径
     */
    public PmmlModel(String pmmlFileName) {
        PMML pmml = null;

        try {
            if (pmmlFileName != null) {
                InputStream is = new FileInputStream(pmmlFileName);
                pmml = PMMLUtil.unmarshal(is);
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("InputStream close error!");
                }

                ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();

                this.modelEvaluator = (Evaluator) modelEvaluatorFactory.newModelEvaluator(pmml);
                modelEvaluator.verify();
                System.out.println("加载模型成功！");
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    // 获取模型需要的特征名称
    public List<String> getFeatureNames() {
        List<String> featureNames = new ArrayList<String>();

        List<InputField> inputFields = modelEvaluator.getInputFields();

        for (InputField inputField : inputFields) {
            featureNames.add(inputField.getName().toString());
        }
        return featureNames;
    }

    // 获取目标字段名称
    public String getTargetName() {
        return modelEvaluator.getTargetFields().get(0).getName().toString();
    }

    // 使用模型生成概率分布
    @SuppressWarnings("unchecked")
	private ProbabilityDistribution<Number> getProbabilityDistribution(Map<FieldName, ?> arguments) {
        Map<FieldName, ?> evaluateResult = modelEvaluator.evaluate(arguments);

        FieldName fieldName = new FieldName(getTargetName());

        return (ProbabilityDistribution<Number>) evaluateResult.get(fieldName);

    }

    // 预测不同分类的概率
    public ValueMap<String, Number> predictProba(Map<FieldName, Number> arguments) {
        ProbabilityDistribution<Number> probabilityDistribution = getProbabilityDistribution(arguments);
        return probabilityDistribution.getValues();
    }

    // 预测结果分类
    public Object predict(Map<FieldName, ?> arguments) {
        ProbabilityDistribution<Number> probabilityDistribution = getProbabilityDistribution(arguments);

        return probabilityDistribution.getPrediction();
    }

    public static void main(String[] args) {
    	PmmlModel clf = new PmmlModel("C:\\Users\\lkai1\\Desktop\\RandomForestClassifier_Iris.pmml");

    	long start = System.currentTimeMillis();
    	
        List<String> featureNames = clf.getFeatureNames();
        System.out.println("feature: " + featureNames);

         // 构建待预测数据
        Map<FieldName, Number> waitPreSample = new HashMap<>();
//        waitPreSample.put(new FieldName("sepal length (cm)"), 10);
//        waitPreSample.put(new FieldName("sepal width (cm)"), 1);
//        waitPreSample.put(new FieldName("petal length (cm)"), 3);
//        waitPreSample.put(new FieldName("petal width (cm)"), 2);
        for(String feture : featureNames) {
        	waitPreSample.put(new FieldName(feture), 10);
        }

        long end = System.currentTimeMillis();
        
        System.out.println("waitPreSample predict result: " + clf.predict(waitPreSample).toString());
        System.out.println("waitPreSample predictProba result: " + clf.predictProba(waitPreSample).toString());

        System.out.println((end - start) + "ms");
    }

}
