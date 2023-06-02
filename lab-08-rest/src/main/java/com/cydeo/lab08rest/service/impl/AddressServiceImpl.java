package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<AddressDTO> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(address -> mapperUtil.convert(address,new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {

        Address address1 = addressRepository.getReferenceById(addressDTO.getId());

        Address convertedAddress = mapperUtil.convert(addressDTO, new Address());
        convertedAddress.setId(address1.getId());
        addressRepository.save(convertedAddress);

        return mapperUtil.convert(convertedAddress, new AddressDTO());
    }

    @Override
    public void create(AddressDTO addressDTO) {
        addressRepository.save(mapperUtil.convert(addressDTO, new Address()));

    }

    @Override
    public List<AddressDTO> getAllByStartsWith(String address) {
        return addressRepository.findAllByStreetStartingWith(address).stream()
                .map(address1 -> mapperUtil.convert(address1, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAllByCustomerId(Long id) {
        return addressRepository.findAllByCustomerId(id).stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAllByCustomerIdAndName(Long id, String name) {
        return addressRepository.findAllByCustomerIdAndName(id, name).stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }
}
