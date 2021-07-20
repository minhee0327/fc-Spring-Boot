package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.Partner;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.PartnerRequest;
import com.example.study.model.network.response.PartnerResponse;
import com.example.study.repository.CategoryRepository;
import com.example.study.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PartnerApiLogicService extends BaseService<PartnerRequest, PartnerResponse, Partner> {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Header<PartnerResponse> create(Header<PartnerRequest> request) {
        // request -> data
        PartnerRequest partnerRequest = request.getData();

        // data -> new partner
        Partner newPartner = Partner.builder()
                .name(partnerRequest.getName())
                .status(partnerRequest.getStatus())
                .address(partnerRequest.getAddress())
                .callCenter(partnerRequest.getCallCenter())
                .partnerNumber(partnerRequest.getPartnerNumber())
                .businessNumber(partnerRequest.getBusinessNumber())
                .ceoName(partnerRequest.getCeoName())
                .registeredAt(LocalDateTime.now())
                .category(categoryRepository.getById(partnerRequest.getCategoryId()))
                .build();

        // save
        Partner partner = baseRepository.save(newPartner);

        // response
        return response(partner);
    }

    @Override
    public Header<PartnerResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(partner -> response(partner))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<PartnerResponse> update(Header<PartnerRequest> request) {
        // request -> data
        PartnerRequest body = request.getData();

        // 찾는 값이 있을 때 update, 없을 때 error 리턴
        return baseRepository.findById(body.getId())
                .map(entityPartner -> {
                    entityPartner
                            .setName(body.getName())
                            .setStatus(body.getStatus())
                            .setAddress(body.getAddress())
                            .setCallCenter(body.getCallCenter())
                            .setPartnerNumber(body.getPartnerNumber())
                            .setBusinessNumber(body.getBusinessNumber())
                            .setCeoName(body.getCeoName())
                            .setRegisteredAt(body.getRegisteredAt())
                            .setUnregisteredAt(body.getUnRegisteredAt())
                            .setCategory(categoryRepository.getById(body.getCategoryId()));

                    return entityPartner;
                })
                .map(newPartner -> baseRepository.save(newPartner))
                .map(partner -> response(partner))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        // 데이터를 가져와서
        // 있으면 지우고 정상 리턴, 없으면 에러 리턴
        return baseRepository.findById(id)
                .map(partner -> {
                    baseRepository.delete(partner);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private Header<PartnerResponse> response(Partner partner) {

        PartnerResponse body = PartnerResponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .address(partner.getAddress())
                .callCenter(partner.getCallCenter())
                .partnerNumber(partner.getPartnerNumber())
                .businessNumber(partner.getBusinessNumber())
                .ceoName(partner.getCeoName())
                .categoryId(partner.getCategory().getId())
                .registeredAt(partner.getRegisteredAt())
                .build();

        return Header.OK(body);
    }
}
