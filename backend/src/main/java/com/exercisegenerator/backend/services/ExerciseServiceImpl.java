package com.exercisegenerator.backend.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

import org.springframework.stereotype.Service;

import com.exercisegenerator.backend.models.Exercise;
import com.exercisegenerator.backend.repositories.ExerciseRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

/**
 * EACH METHOD IS SPECIFIC TO A TYPE OF WORKOUT, MUSCLE GROUP OR DIFFICULTY AND CALLS THE NECESSARY API AND RETURNS INFO FOR THAT API
 */
@AllArgsConstructor
@Service
public class ExerciseServiceImpl implements ExerciseTypeService, ExerciseMuscleGroupService, ExerciseDifficultyService {

    
    private ExerciseRepo exerciseRepo;
    
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String cardio() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?type=cardio"))
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for ( var each : exercises)
                    if(each != null) {
                        exerciseRepo.save(each);
                    }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String olympLifting() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?type=olympic_weightlifting"))
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }

    }

    @Override
    public String plyometrics() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?type=plyometrics"))
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String powerLifting() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?type=powerlifting"))
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String strength() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?type=strength"))
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String stretching() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?type=stretching"))
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String strongMan() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?type=strongman"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    /*
     * Begin muscle group service implementation
     */
    @Override
    public String abdominals() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=abdominals"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String abductors() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=abductors"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String adductors() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=adductors"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String biceps() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=biceps"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String calves() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=calves"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String chest() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=chest"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String forearms() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=forearms"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String glutes() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=glutes"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String hamstrings() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=hamstrings"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String lats() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=lats"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String lowerBack() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=lower_back"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String middleBack() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=middle_back"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String neck() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=neck"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String quadriceps() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=quadriceps"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String traps() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=traps"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String triceps() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?muscle=triceps"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    /**
     * Begin Exercise Difficulty Service Implementation
     */

    @Override
    public String beginner() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?difficulty?beginner"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String expert() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?difficulty?expert"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }
    }

    @Override
    public String intermediate() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/exercises?difficulty?intermediate"))
                .header("Content-Type", "application/json")
                .header("X-Api-Key", "/Mv8fvwyHtpAy+erbqMeFQ==pEFHsbApomMTVcSl")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                String responseBody = response.body();
                List<Exercise> exercises = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Exercise.class));
                for (var each : exercises)
                if(each != null) {
                    exerciseRepo.save(each);
                }
                return responseBody;
            } else {
                String message = ("Failed to fetch data. Status code: " + statusCode);
                return message;
            }
        } catch (Exception e) {
            String message = ("An error occurred: " + e.getMessage());
            return message;
        }

    }

}
