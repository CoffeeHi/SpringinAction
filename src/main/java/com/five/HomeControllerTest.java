package com.five;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Created by 陈祥 on 2016/8/23.
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build(); //搭建MockMvc
        mockMvc.perform(get("/")).andExpect(view().name("home")); //对"/"执行get请求，预期得到home视图
        mockMvc.perform(get("/homepage")).andExpect(view().name("home")); //对"/"执行get请求，预期得到home视图
    }

    @Test //测试SpittleController处理针对"/spittles"的GET请求
    public void shouldShowRecentSpittles() throws Exception {

        List<Spittle> expectedSpittles = createSpittleList(20);

        SpittleRepository mockRepository = mock(SpittleRepository.class); //Mock Repository

        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);

        //Mock SpringMVC
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        //对"/spittles"发起GET请求
        mockMvc.perform(get("/spittles")).andExpect(view().name("spittles")).andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray()))); //断言期望的值
    }

    @Test //用来测试分页Spittle列表的新方法
    public void shouldShowPageSpittles() throws Exception {

        List<Spittle> expectedSpittles = createSpittleList(50);

        SpittleRepository mockRepository = mock(SpittleRepository.class); //Mock Repository

        when(mockRepository.findSpittles(123, 50)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);

        //Mock SpringMVC
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        //对"/spittles"发起GET请求
        mockMvc.perform(get("/spittles?count=50")).andExpect(view().name("spittles")).andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray()))); //断言期望的值
    }

    @Test //测试对某个Spittle的请求，其中ID要在路径变量中指定
    public void testSpittle() throws Exception {

        Spittle expectedSpittle = new Spittle("Hello", new Date());

        SpittleRepository mockRepository = mock(SpittleRepository.class); //Mock Repository

        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);

        //Mock SpringMVC
        MockMvc mockMvc = standaloneSetup(controller).build();

        //通过路径请求资源
        mockMvc.perform(get("/spittles/12345")).andExpect(view().name("spittle")).andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle)); //断言期望的值
    }

    @Test //测试处理表单的控制器
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);

        Spitter unsaved = new Spitter("jbauer" , "24hours" , "Jack" , "Bauer");

        Spitter saved = new Spitter(24L, "jbauer" , "24hours" , "Jack" , "Bauer");

        when(mockRepository.save(unsaved)).thenReturn(saved);
        when(mockRepository.findByUsername("jbauer")).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register").
                param("firstName", "Jack").param("lastName", "Bauer")
                .param("username", "jbauer").param("password", "24hours")).andExpect(redirectedUrl("/spitter/jbauer"));

        verify(mockRepository, atLeastOnce()).save(unsaved); //校验保存情况
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < count; i++){
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
