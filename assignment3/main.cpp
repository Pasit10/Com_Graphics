#undef GLFW_DLL
#include <iostream>
#include <stdio.h>
#include <string>
#include <string.h>
#include <vector>

#include <GL/glew.h>
#include <GLFW/glfw3.h>

#include <vector>
#include <cmath>

#include "Libs/Shader.h"
#include "Libs/Window.h"
#include "Libs/Mesh.h"
#include "Libs/stb_image.h"

#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>

const GLint WIDTH = 800, HEIGHT = 600;

Window mainWindow;
std::vector<Mesh*> meshList;
std::vector<Shader*> shaderList;

glm::vec3 lightColour = glm::vec3(1.0,1.0,1.0);
glm::vec3 lightPos = glm::vec3(5.0f, 5.0f, 0.0f);

float yaw = -90.0f , pitch = 0.0f;

// Vertex Shader
static const char *vShader = "Shaders/shader.vert";

// Fragment Shader
static const char *fShader = "Shaders/shader.frag";

void CreateOBJ()
{
    std::vector<std::string> filePaths;
    filePaths.push_back("Models/button1.obj");
    filePaths.push_back("Models/button2.obj");
    filePaths.push_back("Models/cabinets.obj");
    filePaths.push_back("Models/chair.obj");
    filePaths.push_back("Models/chick.obj");
    filePaths.push_back("Models/floor.obj");
    filePaths.push_back("Models/frigde_handles.obj");
    filePaths.push_back("Models/glassframe.obj");
    filePaths.push_back("Models/glass.obj");
    filePaths.push_back("Models/glassowen.obj");
    filePaths.push_back("Models/light.obj");
    filePaths.push_back("Models/mug.obj");
    filePaths.push_back("Models/owen.obj");
    filePaths.push_back("Models/picture.obj");
    filePaths.push_back("Models/pot1_White.obj");
    filePaths.push_back("Models/pot2_black.obj");
    filePaths.push_back("Models/roof.obj");
    filePaths.push_back("Models/table1.obj");
    filePaths.push_back("Models/table2.obj");
    filePaths.push_back("Models/tray.obj");
    filePaths.push_back("Models/wall.obj");

    std::cout << "file range " << filePaths.size() << std::endl;


    for (const auto& filePath : filePaths)
    {
        Mesh* obj = new Mesh();
        bool loaded_obj =  obj->CreateMeshFromOBJ(filePath.c_str());
        if (loaded_obj)
        {
            meshList.push_back(obj); // Assuming meshList is declared elsewhere
        }
        else
        {
            std::cout<<"Failed to load model"<<std::endl;
        }
    }
}

void CreateShaders()
{
    // Shader *shader1 = new Shader();
    // shader1->CreateFromFiles(vShader, fShader);
    // shaderList.push_back(shader1);
    Shader *shader1 = new Shader();
    shader1->CreateFromFiles(vShader, fShader);
    shaderList.push_back(shader1);
}

std::vector<unsigned int> CreateTexture()
{
    std::vector<std::string> filePaths;
    filePaths.push_back("Textures/button1.jpg");
    filePaths.push_back("Textures/button2.jpg");
    filePaths.push_back("Textures/Cabinets.jpg");
    filePaths.push_back("Textures/chair.jpg");
    filePaths.push_back("Textures/chick.jpg");
    filePaths.push_back("Textures/floor.jpg");
    filePaths.push_back("Textures/Frigde_Handls.jpg");
    filePaths.push_back("Textures/glassframe.jpg");
    filePaths.push_back("Textures/glass.jpg");
    filePaths.push_back("Textures/glassowen.jpg");
    filePaths.push_back("Textures/light_on_top.jpg");
    filePaths.push_back("Textures/mug.jpg");
    filePaths.push_back("Textures/Picture.jpg");
    filePaths.push_back("Textures/pot_black.jpg");
    filePaths.push_back("Textures/pot_White.jpg");
    filePaths.push_back("Textures/roof.jpg");
    filePaths.push_back("Textures/table1.jpg");
    filePaths.push_back("Textures/table2.jpg");
    filePaths.push_back("Textures/tray.jpg");
    filePaths.push_back("Textures/wall.jpg");

    std::cout << "file range " << filePaths.size() << std::endl;

    std::vector<unsigned int> textures(filePaths.size());
    glGenTextures(textures.size(), textures.data());


    for (size_t i = 0; i < filePaths.size(); ++i) {
        glBindTexture(GL_TEXTURE_2D, textures[i]);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        int width, height, nrChannels;
        std::string filename = filePaths[i];
        unsigned char *data = stbi_load(filename.c_str(), &width, &height, &nrChannels, 0);
        if (data)
        {
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE, data);
            glGenerateMipmap(GL_TEXTURE_2D);
        }
        else
        {
            std::cout << "Failed to load texture " << filename << std::endl;
        }
        stbi_image_free(data);
    }

    return textures;
}

void checkMouse(){
    double xPos, yPos;

    glfwGetCursorPos(mainWindow.getWindow(), &xPos, &yPos);

    static float lastX = xPos;
    static float lastY = yPos;

    float xoffset = xPos - lastX;
    float yoffset = lastY - yPos;

    lastX = xPos;
    lastY = yPos;

    float sensitivity = 0.1f;
    xoffset *= sensitivity;
    yoffset *= sensitivity;

    pitch += yoffset;
    yaw += xoffset;

    pitch = glm::clamp(pitch, -89.0f, 89.0f);
}

int main()
{
    mainWindow = Window(WIDTH, HEIGHT, 3, 3);
    mainWindow.initialise();

    glfwSetInputMode(mainWindow.getWindow(), GLFW_CURSOR, GLFW_CURSOR_DISABLED);

    CreateOBJ();
    CreateShaders();

    GLuint uniformModel, uniformProjection, uniformView = 0;

    glm::mat4 projection = glm::perspective(45.0f, (GLfloat) mainWindow.getBufferWidth() / (GLfloat)mainWindow.getBufferHeight(), 0.1f, 100.0f);
    // glm::mat4 projection = glm::ortho(-4.0f, 4.0f, -3.0f, 3.0f, 0.1f, 100.0f);

    glm::vec3 cameraPos = glm::vec3(0.0f, 0.0f, 0.0f);
    glm::vec3 cameraTarget = glm::vec3(0.0f, 0.0f, -1.0f);
    glm::vec3 up = glm::vec3(0.0f, 1.0f, 0.0f);
    glm::vec3 cameraDirection = glm::normalize(cameraTarget - cameraPos);
    glm::vec3 cameraRight = glm::normalize(glm::cross(cameraDirection, up));
    glm::vec3 cameraUp = glm::normalize(glm::cross(cameraRight, cameraDirection));



    std::vector<unsigned int> texture = CreateTexture();

    // Loop until window closed
    float deltaTime, lastFrame;
    while (!mainWindow.getShouldClose())
    {
        // camera
        float currentFrame = static_cast<float>(glfwGetTime());
        deltaTime = currentFrame - lastFrame;
        lastFrame = currentFrame;

        // Get + Handle user input events
        glfwPollEvents();

        checkMouse();

        glm::vec3 direction;
        direction.x = cos(glm::radians(yaw)) * cos(glm::radians(pitch));
        direction.y = sin(glm::radians(pitch));
        direction.z = sin(glm::radians(yaw)) * cos(glm::radians(pitch));
        cameraDirection = glm::normalize(direction);

        if(glfwGetKey(mainWindow.getWindow(), GLFW_KEY_W) == GLFW_PRESS){
            cameraPos += cameraDirection * deltaTime * 5.0f;
        }
        if(glfwGetKey(mainWindow.getWindow(), GLFW_KEY_S) == GLFW_PRESS){
            cameraPos -= cameraDirection * deltaTime * 5.0f;
        }
        if(glfwGetKey(mainWindow.getWindow(), GLFW_KEY_A) == GLFW_PRESS){
            cameraPos -= cameraRight * deltaTime * 5.0f;
        }
        if(glfwGetKey(mainWindow.getWindow(), GLFW_KEY_D) == GLFW_PRESS){
            cameraPos += cameraRight * deltaTime * 5.0f;
        }
        if(glfwGetKey(mainWindow.getWindow(), GLFW_KEY_ESCAPE) == GLFW_PRESS){
            glfwSetInputMode(mainWindow.getWindow(), GLFW_CURSOR, GLFW_CURSOR_NORMAL);
        }

        cameraRight = glm::normalize(glm::cross(cameraDirection, up));
        cameraUp = glm::normalize(glm::cross(cameraRight, cameraDirection));

        // Clear window
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        glm::mat4 view (1.0f);

        glm::mat4 cameraPosMat (1.0f);
        cameraPosMat[3][0] = -cameraPos.x;
        cameraPosMat[3][1] = -cameraPos.y;
        cameraPosMat[3][2] = -cameraPos.z;
        glm::mat4 cameraRotateMat(1.0f);
        cameraRotateMat[0] = glm::vec4(cameraRight.x, cameraUp.x, -cameraDirection.x, 0.0f);
        cameraRotateMat[1] = glm::vec4(cameraRight.y, cameraUp.y, -cameraDirection.y, 0.0f);
        cameraRotateMat[2] = glm::vec4(cameraRight.z, cameraUp.z, -cameraDirection.z, 0.0f);

        view = cameraRotateMat * cameraPosMat;

        // draw here

        shaderList[0]->UseShader();
        uniformModel = shaderList[0]->GetUniformLocation("model");
        uniformProjection = shaderList[0]->GetUniformLocation("projection");
        uniformView = shaderList[0]->GetUniformLocation("view");

        /*
            Object 0 cabinets
            Object 1 chair
            Object 2 chick
            Object 3 floor
            Object 4 frigde_handle
            Object 5 glassframe
            Object 6 glass
            Object 7 light
            Object 8 light_on_top
            Object 9 livingroom
            Object 10 mug
            Object 11 owen
            Object 12 picture
            Object 13 pot1_while
            Object 14 pot2_black
            Object 15 roof
            Object 16 table1
            Object 17 table2
            Object 18 tray
            Object 19 wall

            20 Object
        */
        // all object
        int n_object = 20;
        int n_object_by_texture = texture.size();
        for(int i = 0;i < n_object_by_texture;i++){
            glm::mat4 model (1.0f);

            glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
            glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));
            glUniformMatrix4fv(uniformProjection, 1, GL_FALSE, glm::value_ptr(projection));

            glActiveTexture(GL_TEXTURE0);
            glBindTexture(GL_TEXTURE_2D, texture[i]);

            //light
            glUniform3fv(shaderList[0]->GetUniformLocation("lightColour"), 1, (GLfloat *)&lightColour);
            glUniform3fv(shaderList[0]->GetUniformLocation("lightPos"), 1, (GLfloat *)&lightPos);
            glUniform3fv(shaderList[0]->GetUniformLocation("viewPos"), 1, (GLfloat *)&cameraPos);
            meshList[i]->RenderMesh();
        }

        // end draw
        glUseProgram(0);

        mainWindow.swapBuffers();
    }

    return 0;
}